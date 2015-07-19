package com.book.repository;

import com.book.entity.Book;
import com.book.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {


    /*Image findByBook(Book book);*/
}
