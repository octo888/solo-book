package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Image;
import com.book.service.BookService;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/{id}")
    public String showBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findOneAndCountRate(id));
        /*model.addAttribute("category", categoryService.findOneByTitle(title));*/
        return "book";
    }


    @RequestMapping(value = "/rate/{id}")
    public String doAddRate(@PathVariable int id, @RequestParam(value = "rate") Integer rate) {
        bookService.addRate(id, rate);
        return "redirect:/{id}.html";
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

    /*@RequestMapping(value = "/image/imageDisplay", method = RequestMethod.GET)
    @ResponseBody
    public void showImage(@RequestParam("id") Integer id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

            Image image = bookService.getImage(id);
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(image.getBody());
            response.getOutputStream().flush();
            response.getOutputStream().close();
    }*/

    /*@RequestMapping(value = "/image/imageDisplay", method = RequestMethod.GET)
    @ResponseBody
    public byte[] showImage(@RequestParam("id") Integer id)
    {
        Image image = bookService.getImage(id);
        return image.getBody();
    }*/



}