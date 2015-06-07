package com.book.controller;


import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "index";
    }
}
