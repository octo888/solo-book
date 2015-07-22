package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.entity.Image;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin/addbook")
    public String showAddBook(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "addbook";
    }


    @RequestMapping(value = "/admin/addbook", method = RequestMethod.POST)
    public String doAddBook(@RequestParam(value = "selectCategory") String categoryName,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "authorName") String authorName,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "image") MultipartFile image,
                            HttpServletResponse response) {

        try {
            Category category = categoryService.findOneByName(categoryName);

            Book book = new Book();
            book.setName(name);
            book.setAuthorName(authorName);
            book.setDescription(description);
            book.setCategory(category);

            book.setImage(image.isEmpty() ? null : new Image(image.getOriginalFilename(), image.getBytes()));

            bookService.save(book);
            return "redirect:/admin/addbook.html";
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }

    }


    @RequestMapping("/admin/categories/{title}/remove/book/{id}")
    public String removeBook(@PathVariable int id, @PathVariable String title) {
        bookService.delete(id);
        return "redirect:/admin/categories/{title}.html";
    }
}
