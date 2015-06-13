package com.book.controller;

import com.book.entity.Category;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public String book(Model model) {
        model.addAttribute("book", bookService.findAll());
        return "book";
    }


}
