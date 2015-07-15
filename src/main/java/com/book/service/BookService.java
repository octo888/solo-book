package com.book.service;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.entity.Image;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import com.book.repository.ImageRepository;
import com.book.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private RateRepository rateRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.findOne(id);
    }

    public void save(Book book, String title) {
        Category category = categoryRepository.findOneByTitle(title);
        book.setCategory(category);
        bookRepository.save(book);
    }

    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    public void delete(int id) {
        bookRepository.delete(id);
    }


}
