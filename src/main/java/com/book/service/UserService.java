package com.book.service;


import com.book.entity.Book;
import com.book.entity.Role;
import com.book.entity.User;
import com.book.repository.BookRepository;
import com.book.repository.RoleRepository;
import com.book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOneByName(String name) {
        return userRepository.findByName(name);
    }

    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public void addBookInList(Integer id, String name) {
        User user = userRepository.findByName(name);
        Book book = bookRepository.findOne(id);

        List<Book> books = user.getBooks();
        books.add(book);
        user.setBooks(books);

        userRepository.saveAndFlush(user);
    }


    public List<Book> getUserBookList(String userName) {
        User user = userRepository.findByName(userName);
        List<Book> books = user.getBooks();
        for (Book book : books) {
            book.getImage().getId();
        }
        return books;
    }

    public void removeFromBookList(Integer id, String name) {
        User user = userRepository.findByName(name);
        Book book = bookRepository.findOne(id);

        List<Book> books = user.getBooks();
        books.remove(book);
        user.setBooks(books);

        userRepository.saveAndFlush(user);
    }


    public List<User> findInBookList(int id) {
        Book book = bookRepository.findOne(id);
        return userRepository.findByBooks(book);
    }
}
