package com.book.service;

import com.book.entity.Book;
import com.book.entity.TopList;
import com.book.repository.BookRepository;
import com.book.repository.TopListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TopListService {

    @Autowired
    private TopListRepository topListRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<TopList> findAll() {
        return topListRepository.findAll();
    }

    public TopList findOneByTitle(String title) {

        TopList topList = topListRepository.findOneByTitle(title);
        Map<Integer, Book> books = topList.getBooks();
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            entry.getValue().getImage();
        }

        return topList;
    }

    public void save(TopList topList) {
        topListRepository.save(topList);
    }

    public void delete(int id) {
        topListRepository.delete(id);
    }

    public void rename(int id, String name) {
        TopList topList = topListRepository.findOne(id);
        topList.setName(name);
        topListRepository.saveAndFlush(topList);
    }


    public void addBook(String title, String bookName, Integer key) {
        TopList topList = topListRepository.findOneByTitle(title);

        Book book = bookRepository.findOneByName(bookName);

        Map<Integer, Book> books = topList.getBooks();
        books.put(key, book);

        topList.setBooks(books);
        topListRepository.saveAndFlush(topList);
    }

    public void removeBook(String title, int id) {
        TopList topList = topListRepository.findOneByTitle(title);

        Book book = bookRepository.findOne(id);

        Map<Integer, Book> books = topList.getBooks();

        while (books.values().remove(book));

        topList.setBooks(books);
        topListRepository.saveAndFlush(topList);

    }

    public List<TopList> findByBookId(int id) {
        Book book = bookRepository.findOne(id);
        return topListRepository.findByBooks(book);
    }
}
