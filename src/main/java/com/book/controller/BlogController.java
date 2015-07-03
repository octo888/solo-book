package com.book.controller;

import com.book.entity.Blog;
import com.book.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/remove/{id}")
    public String removeBlog(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account.html";
    }

    @RequestMapping
    public String showBlogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blogs";
    }

    @RequestMapping("/{id}")
    public String blogPage(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findOne(id));
        return "blog";
    }
}
