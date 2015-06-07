package com.book.controller;

import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/book")
    public String book(Model model) {
        model.addAttribute("book", bookService.findAll());
        return "book";
    }


    @RequestMapping("/category/{title}")
    public String category(Model model, @PathVariable String title) {
        model.addAttribute("cat", categoryService.findOneWithBooks(title));
        return "category";
    }
}
