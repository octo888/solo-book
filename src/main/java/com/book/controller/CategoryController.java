package com.book.controller;

import com.book.entity.Category;
import com.book.service.CategoryService;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category/{title}")
    public String category(Model model, @PathVariable String title) {
        model.addAttribute("category", categoryService.findOneWithBooks(title));
        return "category";
    }

}
