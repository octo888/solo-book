package com.book.repository;

import com.book.entity.Book;
import com.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    List<User> findByBooks(Book book);
}
