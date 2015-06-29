package com.book.repository;

import com.book.entity.Blog;
import com.book.entity.BlogItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogItemRepository extends JpaRepository<BlogItem, Integer> {

    List<BlogItem> findByBlog(Blog blog, Pageable pageable);
}
