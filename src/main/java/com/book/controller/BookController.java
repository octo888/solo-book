package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Image;
import com.book.service.BookService;
import com.book.service.CategoryService;
import com.book.service.TopListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private TopListService topListService;

    @RequestMapping("/{id}")
    public String showBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOneAndCountRate(id));
        model.addAttribute("toplists", topListService.findAll());
        return "book";
    }


    @RequestMapping(value = "/rate/{id}")
    public String doAddRate(@PathVariable int id, @RequestParam(value = "rate") Integer rate) {
        bookService.addRate(id, rate);
        return "redirect:/{id}.html";
    }

    @RequestMapping("/image/{file_id}")
    public void getImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("file_id") int id) throws IOException {
        try {
            Image content = bookService.getImage(id);
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(content.getBody());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}