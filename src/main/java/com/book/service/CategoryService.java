package com.book.service;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Category findOneByTitle(String title) {
        return categoryRepository.findOneByTitle(title);
    }

    public Category findOneByName(String categoryName) {
        return categoryRepository.findOneByName(categoryName);
    }

    public Category findOneWithBooks(String title) {
        Category category = findOneByTitle(title);
        List<Book> books = bookRepository.findByCategory(category, new PageRequest(0, 16, Sort.Direction.ASC, "name"));
        category.setBooks(books);
        return category;
    }

    public Page<Book> getPageWithBooks(String title, int pageNumber) {
        Category category = findOneByTitle(title);
        PageRequest pageRequest = new PageRequest(pageNumber - 1, 18, Sort.Direction.ASC, "name");
        return bookRepository.findPagesByCategory(category, pageRequest);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void delete(int id) {
        categoryRepository.delete(id);
    }

    public void rename(int id, String name) {
        Category category = categoryRepository.findOne(id);
        category.setName(name);
        categoryRepository.saveAndFlush(category);
    }


}
