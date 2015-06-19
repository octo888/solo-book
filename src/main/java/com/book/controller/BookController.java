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

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("add_book")
    public Book constructBook() {
        return new Book();
    }

    @RequestMapping("/category/{title}/{id}")
    public String showBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

    @RequestMapping("/categories/{title}/addbook")
    public String showAddBook() {
        return "addbook";
    }


    @RequestMapping(value = "/categories/{title}/addbook", method = RequestMethod.POST)
    public String doAddBook(@PathVariable String title, @ModelAttribute("add_book") Book book) {
        bookService.save(book, title);
        return "redirect:/categories/{title}.html";
    }


    /*@RequestMapping(value = "/add", method = RequestMethod.POST)
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

    } */

    @RequestMapping("/categories/{title}/remove/book/{id}")
    public String removeCategory(@PathVariable int id, @PathVariable String title) {
        bookService.delete(id);
        return "redirect:/categories/{title}.html";
    }
}