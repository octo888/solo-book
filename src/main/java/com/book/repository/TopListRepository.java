package com.book.repository;


import com.book.entity.Book;
import com.book.entity.TopList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopListRepository extends JpaRepository<TopList, Integer> {
    TopList findOneByTitle(String title);

    List<TopList> findByBooks(Book book);
}
