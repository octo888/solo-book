package com.book.service;

import com.book.entity.Book;
import com.book.entity.TopList;
import com.book.repository.BookRepository;
import com.book.repository.TopListRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TopListService {

    @Autowired
    private TopListRepository topListRepository;

    @Autowired
    private BookRepository bookRepository;

    private final String TOPLIST_FOR_CAROUSEL = "topmonth";

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

    public String getPluginImages() {
        Map<Integer, Book> map = topListRepository.findOneByTitle(TOPLIST_FOR_CAROUSEL).getBooks();
        List<Book> books = new ArrayList<>(map.values());
        List<String> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getImage() != null) {
                list.add("/image/" + book.getImage().getId() + ".html");
            } else list.add("#");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPluginLinks() {
        Map<Integer, Book> map = topListRepository.findOneByTitle(TOPLIST_FOR_CAROUSEL).getBooks();
        List<Book> books = new ArrayList<>(map.values());
        List<String> list = new ArrayList<>();
        for (Book book : books) {
            if (book != null) {
                list.add("/" + book.getId() + ".html");
            } else list.add("#");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<TopList> findByBookId(int id) {
        Book book = bookRepository.findOne(id);
        return topListRepository.findByBooks(book);
    }
}
