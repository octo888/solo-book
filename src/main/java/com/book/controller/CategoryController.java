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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Category constructCategory() {
        return new Category();
    }

    @RequestMapping("/category/{title}")
    public String category(Model model, @PathVariable String title) {
        model.addAttribute("category", categoryService.findOneWithBooks(title));
        return "category";
    }

    @RequestMapping("/admin/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @RequestMapping("/admin/categories/{title}")
    public String categoryDetail(Model model, @PathVariable String title) {
        model.addAttribute("category", categoryService.findOneWithBooks(title));
        return "category-detail";
    }

    @RequestMapping(value = "/admin/categories", method = RequestMethod.POST)
    public String doAddCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories.html";
    }

    @RequestMapping("/admin/categories/remove/{id}")
    public String removeCategory(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/admin/categories.html";
    }



}
