package com.book.repository;


import com.book.entity.TopList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopListRepository extends JpaRepository<TopList, Integer> {
    TopList findOneByTitle(String title);


}
