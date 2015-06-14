package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

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
    public String showAddBook() {
        return "addbook";
    }

    @RequestMapping(value = "/categories/{id}/addbook", method = RequestMethod.POST)
    public String doAddBook(@PathVariable int id, @ModelAttribute("addBook") Book book) {
        bookService.save(book, id);
        return "redirect:/categories/{id}.html";
    }
}
