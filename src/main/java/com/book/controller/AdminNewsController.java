package com.book.controller;

import com.book.entity.NewsBlog;
import com.book.service.NewsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/newsblog")
public class AdminNewsController {

    @Autowired
    private NewsBlogService newsBlogService;

    @ModelAttribute("newsblog")
    public NewsBlog constructNewsBlog() {
        return new NewsBlog();
    }

    @RequestMapping
    public String showAdminNews(Model model) {
        model.addAttribute("newsblogs", newsBlogService.findAll());
        return "newsblog";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doAddNewsBlog(Model model, @Valid @ModelAttribute("newsblog") NewsBlog blog,  BindingResult result) {
        if (result.hasErrors()) {
            return showAdminNews(model);
        }
        newsBlogService.save(blog);
        return "redirect:/admin/newsblog.html";
    }

    @RequestMapping("/remove/{id}")
    public String removeNewsBlog(@PathVariable Long id) {
        newsBlogService.delete(id);
        return "redirect:/admin/newsblog.html";
    }

}
