package com.book.repository;

import com.book.entity.Book;
import com.book.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByCategory(Category category, Pageable pageable);

}
