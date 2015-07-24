package com.book.controller;

import com.book.entity.Blog;
import com.book.service.BlogService;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public String showBlogs(Model model, Integer pageNumber) {
        pageNumber = 1;
        return getBlogPage(pageNumber, model);
    }

    @RequestMapping("/{id}")
    public String blogPage(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findOne(id));
        return "blog";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String getBlogPage(@PathVariable Integer pageNumber, Model model) {
        Page<Blog> page = blogService.getBlogPage(pageNumber);
        List<Blog> blogs = page.getContent();
        model.addAttribute("blogs", blogs);

        int current = page.getNumber() + 1;
        int begin = 1;//Math.max(1, current - 2);
        int end = page.getTotalPages();//Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("current", current);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);

        return "blogs";
    }

    @RequestMapping("/remove/{id}")
    public String removeBlog(@PathVariable int id, Principal principal) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        String name = principal.getName();
        if (name.equals("admin")){
            return "redirect:/blogs.html";
        }
        return "redirect:/account.html";
    }

}
