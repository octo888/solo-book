package com.book.service;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findOne(int id) {
        return categoryRepository.findOne(id);
    }

    public Category findOneByTitle(String title) {
        return categoryRepository.findOneByTitle(title);
    }

    @Transactional
    public Category findOneWithBooks(String title) {
        Category category = findOneByTitle(title);
        List<Book> books = bookRepository.findByCategory(category, new PageRequest(0, 16, Sort.Direction.ASC, "name"));
        category.setBooks(books);
        return category;
    }
}
