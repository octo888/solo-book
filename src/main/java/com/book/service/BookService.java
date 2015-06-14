package com.book.service;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.findOne(id);
    }

    public void save(Book book, int id) {
        Category category = categoryRepository.findOne(id);
        book.setCategory(category);
        bookRepository.save(book);
    }
}
