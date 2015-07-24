package com.book.controller;

import com.book.entity.Blog;
import com.book.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class UserController {

    @Autowired
    private BlogService blogService;


    @ModelAttribute("blog")
    public Blog constructBlog() {
        return new Blog();
    }

    @RequestMapping
    public String account(Model model, Principal principal) {
        return getBlogPage(1, model, principal);
    }


    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String getBlogPage(@PathVariable Integer pageNumber,
                              Model model, Principal principal) {
        Page<Blog> page = blogService.getBlogPageForUser(pageNumber, principal.getName());
        List<Blog> blogs = page.getContent();

        model.addAttribute("blogs", blogs);

        int current = page.getNumber() + 1;
        int begin = 1;//Math.max(1, current - 2);
        int end = page.getTotalPages();//Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("current", current);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);

        return "user-account";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addBlog(Model model,
                            @Valid @ModelAttribute("blog") Blog blog, BindingResult result,
                            Principal principal) {
        if (result.hasErrors()) {
            return account(model, principal);
        }
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.POST)
    public String doAddBlog(Model model,
                            @Valid @ModelAttribute("blog") Blog blog, BindingResult result,
                            Principal principal) {
        return addBlog(model, blog, result, principal);
    }



}
