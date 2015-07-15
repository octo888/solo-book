package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Image;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin/categories/{title}")
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @ModelAttribute("add_book")
    public Book constructBook() {
        return new Book();
    }

    @RequestMapping("/{id}")
    public String showAdminBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

    @RequestMapping("/addbook")
    public String showAddBook() {
        return "addbook";
    }


    /*@RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String doAddBook(@PathVariable String title, @ModelAttribute("add_book") Book book) {
        bookService.save(book, title);
        return "redirect:/admin/categories/{title}.html";
    }*/

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String doAddBook(@PathVariable String title, @RequestParam(value = "name") String name,
                            @RequestParam(value = "image") MultipartFile image,
                            HttpServletResponse response) {

        try {
            Book book = new Book();
            book.setName(name);
            book.setImage(image.isEmpty() ? null : new Image(image.getOriginalFilename(), image.getBytes()));

            bookService.save(book, title);
            return "redirect:/admin/categories/{title}.html";
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }

    }


    @RequestMapping("/remove/book/{id}")
    public String removeCategory(@PathVariable int id, @PathVariable String title) {
        bookService.delete(id);
        return "redirect:/admin/categories/{title}.html";
    }
}
