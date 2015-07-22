package com.book.repository;

import com.book.entity.NewsBlog;
import com.book.entity.NewsItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface NewsItemRepository extends JpaRepository<NewsItem, Long> {

    List<NewsItem> findByNewsBlog(NewsBlog blog, Pageable pageable);

    NewsItem findByNewsBlogAndLink(NewsBlog blog, String link);
}
