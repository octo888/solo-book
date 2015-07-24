package com.book.controller;

import com.book.entity.Book;
import com.book.entity.Category;
import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return getCategoryWithPageBook(1, title, model);
    }

    @RequestMapping(value = "/{title}/page/{pageNumber}", method = RequestMethod.GET)
    public String getCategoryWithPageBook(@PathVariable Integer pageNumber,
                                          @PathVariable String title,
                                          Model model) {
        Page<Book> page = categoryService.getPageWithBooks(title, pageNumber);
        List<Book> books = page.getContent();
        model.addAttribute("books", books);
        model.addAttribute("category", categoryService.findOneByTitle(title));

        int current = page.getNumber() + 1;
        int begin = 1;//Math.max(1, current - 2);
        int end = page.getTotalPages();//Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("current", current);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);

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
