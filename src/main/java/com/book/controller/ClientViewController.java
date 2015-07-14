package com.book.controller;


import com.book.service.CategoryService;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Controller
public class ClientViewController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TopListService topListService;

    @RequestMapping("/category/{title}")
    public String category(Model model, @PathVariable String title) {
        model.addAttribute("category", categoryService.findOneWithBooks(title));
        return "category";
    }

    @RequestMapping("/toplist/{title}")
    public String toplist(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneWithBooks(title));
        return "toplist";
    }

}
