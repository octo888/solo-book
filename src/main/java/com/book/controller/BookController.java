package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/category/{title}/{id}")
    public String showBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

}