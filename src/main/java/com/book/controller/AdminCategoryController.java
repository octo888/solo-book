package com.book.controller;

import com.book.entity.Category;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Category constructCategory() {
        return new Category();
    }

    @RequestMapping
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @RequestMapping("/{title}")
    public String categoryDetail(Model model, @PathVariable String title) {
        model.addAttribute("category", categoryService.findOneWithBooks(title));
        return "category-detail";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doAddCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories.html";
    }

    @RequestMapping("/remove/{id}")
    public String removeCategory(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/admin/categories.html";
    }
}
