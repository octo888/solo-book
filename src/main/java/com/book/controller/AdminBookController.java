package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/categories")
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @ModelAttribute("add_book")
    public Book constructBook() {
        return new Book();
    }

    @RequestMapping("/{title}/{id}")
    public String showAdminBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

    @RequestMapping("/{title}/addbook")
    public String showAddBook() {
        return "addbook";
    }


    @RequestMapping(value = "/{title}/addbook", method = RequestMethod.POST)
    public String doAddBook(@PathVariable String title, @ModelAttribute("add_book") Book book) {
        bookService.save(book, title);
        return "redirect:/admin/categories/{title}.html";
    }


    @RequestMapping("/{title}/remove/book/{id}")
    public String removeCategory(@PathVariable int id, @PathVariable String title) {
        bookService.delete(id);
        return "redirect:/admin/categories/{title}.html";
    }
}
