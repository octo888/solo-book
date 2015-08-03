package com.book.service;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.entity.Image;
import com.book.entity.TopList;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import com.book.repository.ImageRepository;
import com.book.repository.TopListRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private TopListRepository topListRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
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
            res = new BigDecimal(res).setScale(1, RoundingMode.UP).doubleValue();
            book.setRate(res);
            bookRepository.saveAndFlush(book);
        }

        return book;
    }

    public void addTopListIntoBook(Integer id, Integer key, String topListName) {
        Book book = bookRepository.findOne(id);
        TopList topList = topListRepository.findOneByName(topListName);

        Map<Integer, Book> books = topList.getBooks();
        books.put(key, book);

        topList.setBooks(books);
        topListRepository.saveAndFlush(topList);
    }

}
