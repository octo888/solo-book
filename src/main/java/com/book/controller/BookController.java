package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Image;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/category/{title}/{id}")
    public String showBookInCategory(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

    @RequestMapping("/toplist/{title}/{id}")
    public String showBookInTopList(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }

    /*@RequestMapping("/image/{file_id}")
    public void getFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("file_id") int id) {
        try {
            Image content = bookService.getImage(id);
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(content.getBody());
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    @RequestMapping(value = "/image/imageDisplay", method = RequestMethod.GET)
    @ResponseBody
    public void showImage(@RequestParam("id") Integer id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

            Image image = bookService.getImage(id);
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(image.getBody());
            response.getOutputStream().flush();
            response.getOutputStream().close();


    }

}