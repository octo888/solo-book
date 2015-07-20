package com.book.service;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.entity.Image;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import com.book.repository.ImageRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
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


    public void delete(int id) {
        bookRepository.delete(id);
    }

    public Image getImage(int id) {
        return imageRepository.findOne(id);
    }

    public void addRate(int id, Integer rate) {
        Book book = bookRepository.findOne(id);
        /*Hibernate.initialize(book.getRates());*/
        List<Integer> rates = book.getRates();
        rates.add(rate);
        bookRepository.saveAndFlush(book);
    }


    public Book findOneAndCountRate(int id) {
        Book book = bookRepository.findOne(id);
        List<Integer> rates = book.getRates();

        if (rates.size() != 0) {
            int sum = 0;
            int divider = rates.size();
            for (int i = 0; i < divider; i++) {
                sum += rates.get(i);
            }
            double res = (double) sum / divider;
            res = new BigDecimal(res).setScale(2, RoundingMode.UP).doubleValue();
            book.setRate(res);
            bookRepository.saveAndFlush(book);
        }

        return book;
    }


    /*public Book findOneWithImage(int id) {
        Book book = bookRepository.findOne(id);
        Image image = imageRepository.findByBook(book);
        book.setImage(image);
        return book;
    }*/
}
