package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Image;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    /*@ModelAttribute("addBook")
    public Book constructBook() {
        return new Book();
    } */

    @RequestMapping("/category/{title}/{id}")
    public String showBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

    @RequestMapping("/addbook")
    public String showAddBook() {
        return "addbook";
    }


   /* @RequestMapping(value = "/categories/{id}/addbook", method = RequestMethod.POST)
    public String doAddBook(@PathVariable int id, @ModelAttribute("addBook") Book book) {
        bookService.save(book, id);
        return "redirect:/categories/{id}.html";
    } */


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAddBook( @RequestParam(value="name") String name,
                             @RequestParam(value="category") String category,
                             @RequestParam(value="image") MultipartFile file,
                             HttpServletRequest request,
                             HttpServletResponse response)  {

        try {
            Image image =  new Image(file.getOriginalFilename(), file.getBytes());
            bookService.saveImage(image);

            Book book = new Book();
            book.setName(name);
            book.setImage(image);

            bookService.save(book, category);
            return "redirect:/categories.html";
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }

    }

    @RequestMapping("/categories/{title}/remove/book/{id}")
    public String removeCategory(@PathVariable int id, @PathVariable String title) {
        bookService.delete(id);
        return "redirect:/categories/{title}.html";
    }
}