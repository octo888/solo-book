package com.book.service;

import com.book.entity.Book;
import com.book.entity.TopList;
import com.book.repository.BookRepository;
import com.book.repository.TopListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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


    public TopList findOneWithBooks(String title) {

        TopList topList = topListRepository.findOneByTitle(title);

        List<Book> books = bookRepository.findByTopLists(topList, new PageRequest(0, 50, Sort.Direction.ASC, "name"));

        topList.setBooks(books);
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

    public TopList findOne(String title) {
        return topListRepository.findOneByTitle(title);
    }

    public void addBook(String title, String bookName) {
        TopList topList = findOneWithBooks(title);

        Book book = bookRepository.findOneByName(bookName);

        List<TopList> bookTops = topListRepository.findByBooks(book);
        bookTops.add(topList);

        List<Book> books = bookRepository.findByTopLists(topList, new PageRequest(0, 50, Sort.Direction.ASC, "name"));
        books.add(book);

        topList.setBooks(books);
        topListRepository.saveAndFlush(topList);
    }
}
