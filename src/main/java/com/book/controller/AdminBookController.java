package com.book.controller;

import com.book.entity.*;
import com.book.service.BookService;
import com.book.service.CategoryService;
import com.book.service.TopListService;
import com.book.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TopListService topListService;

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String doAddTopListIntoBook(@PathVariable Integer id,
                                       @RequestParam(value = "selectTopList") String topListName,
                                       @RequestParam(value = "key") Integer key) {
        bookService.addTopListIntoBook(id, key, topListName);
        return "redirect:/{id}.html";
    }


    @RequestMapping("/admin/remove/book/{id}")
    public String removeBook(@PathVariable int id, RedirectAttributes redirectAttributes) {
        List<TopList> topLists = topListService.findByBookId(id);
        List<User> users = userService.findInBookList(id);

        if (!topLists.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", true);
            redirectAttributes.addFlashAttribute("lists", topLists);
            return "redirect:/{id}.html";
        }
        if (!users.isEmpty()) {
            for (User user: users) {
                userService.removeFromBookList(id, user.getName());
            }
        }
        bookService.delete(id);
        return "redirect:/admin/categories.html";
    }
}
