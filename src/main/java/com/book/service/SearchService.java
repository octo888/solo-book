package com.book.service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findBooksByPattern(String pattern) {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            String name = book.getName().toLowerCase();
            if (name.contains(pattern.toLowerCase())) {
                result.add(book);
            }

            String authorName = book.getAuthorName().toLowerCase();
            if (authorName.contains(pattern.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}
