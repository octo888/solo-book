package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("addBook")
    public Book constructBook() {
        return new Book();
    }

    @RequestMapping("/book")
     public String book(Model model) {
        model.addAttribute("book", bookService.findAll());
        return "book";
    }

    @RequestMapping("/categories/{id}/addbook")
    public String doAddBook(@ModelAttribute("addBook") Book book) {
        bookService.save(book);
        return "addbook";
    }
}
