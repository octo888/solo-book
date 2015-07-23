package com.book.controller;

import com.book.entity.Blog;
import com.book.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String getRunbookPage(@PathVariable Integer pageNumber, Model model) {
        Page<Blog> page = blogService.getPage(pageNumber);

        List<Blog> blogs = page.getContent();
        model.addAttribute("blogs", blogs);

        /*int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("blogPages", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);*/

        return "blogs";
    }
}
