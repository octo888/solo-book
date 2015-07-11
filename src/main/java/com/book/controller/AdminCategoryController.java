package com.book.controller;

import com.book.entity.Category;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/rename/{id}", method = RequestMethod.POST)
    public String renameCategory(@PathVariable int id, @RequestParam(value = "name") String name) {
        categoryService.rename(id, name);
        return "redirect:/admin/categories.html";
    }
}
