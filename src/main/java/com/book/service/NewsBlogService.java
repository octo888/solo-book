package com.book.service;

import com.book.entity.NewsBlog;
import com.book.entity.NewsItem;
import com.book.exception.RssException;
import com.book.repository.NewsBlogRepository;
import com.book.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsBlogService {

    @Autowired
    NewsBlogRepository newsBlogRepository;

    @Autowired
    RssService rssService;

    @Autowired
    NewsItemRepository newsItemRepository;

    public List<NewsItem> getItemsForIndex() {
        return newsItemRepository.findAll(new PageRequest(0, 3, Sort.Direction.DESC, "publishedDate")).getContent();
    }

    public List<NewsItem> getItems() {
        return newsItemRepository.findAll(new PageRequest(0, 20, Sort.Direction.DESC, "publishedDate")).getContent();
    }

    public void saveItems(NewsBlog blog) {
        try {
            List<NewsItem> items = rssService.getItems(blog.getUrl());
            for (NewsItem item : items) {
                NewsItem savedItem = newsItemRepository.findByNewsBlogAndLink(blog, item.getLink());
                if (savedItem == null) {
                    item.setNewsBlog(blog);
                    newsItemRepository.save(item);
                }
            }
        } catch (RssException e) {
            e.printStackTrace();
        }
    }

    public void save(NewsBlog blog) {
        newsBlogRepository.save(blog);
        saveItems(blog);
    }

    public void delete(long id) {
        newsBlogRepository.delete(id);
    }


    public List<NewsBlog> findAll() {
        List<NewsBlog> list = newsBlogRepository.findAll();
        for (NewsBlog blog : list) {
            List<NewsItem> items = newsItemRepository.findByNewsBlog(blog,
                    new PageRequest(0, 10, Sort.Direction.DESC, "publishedDate"));
            blog.setItems(items);
        }
        return list;
    }

    @Scheduled(fixedDelay=1800000)
    public void reloadBlogs() {
        List<NewsBlog> blogs = newsBlogRepository.findAll();
        for (NewsBlog blog : blogs) {
            saveItems(blog);
        }
    }
}
