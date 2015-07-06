package com.book.service;

import com.book.entity.Book;
import com.book.entity.TopList;
import com.book.repository.BookRepository;
import com.book.repository.TopListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopListService {

    @Autowired
    private TopListRepository topListRepository;

    @Autowired
    private BookRepository bookRepository;

    @ModelAttribute("toplist")
    public TopList constructTopList() {
        return new TopList();
    }

    public List<TopList> findAll() {
        return topListRepository.findAll();
    }

    public TopList findOneWithBooks(String title) {
        TopList topList = topListRepository.findOneByTitle(title);
        List<Book> books = bookRepository.findByTopList(topList, new PageRequest(0, 50, Sort.Direction.ASC, "name"));
        topList.setBooks(books);
        return topList;
    }

    public void save(TopList topList) {
        topListRepository.save(topList);
    }

    public void delete(int id) {
        topListRepository.delete(id);
    }
}
