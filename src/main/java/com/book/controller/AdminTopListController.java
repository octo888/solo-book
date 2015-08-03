package com.book.controller;

import com.book.entity.TopList;
import com.book.service.BookService;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/toplists")
public class AdminTopListController {

    @Autowired
    private TopListService topListService;

    @Autowired
    private BookService bookService;

    @ModelAttribute("toplist")
    public TopList constructToplist(){
        return new TopList();
    }


    @RequestMapping
    public String toplist(Model model) {
        model.addAttribute("toplists", topListService.findAll());
        return "toplists-admin";
    }

    @RequestMapping("/{title}")
    public String topListDetail(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneByTitle(title));
        model.addAttribute("books", bookService.findAll());
        return "toplist-detail";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doAddTopList(@ModelAttribute("toplist") TopList topList) {
        topListService.save(topList);
        return "redirect:/admin/toplists.html";
    }

    @RequestMapping(value = "/{title}", method = RequestMethod.POST)
    public String doAddBooksInTopList(@RequestParam(value = "selectedBook") String bookName,
                                      @RequestParam(value = "key") Integer key,
                                      @PathVariable String title) {
        topListService.addBook(title, bookName, key);
        return "redirect:/admin/toplists/{title}.html";
    }

    @RequestMapping("/remove/{id}")
    public String removeTopList(@PathVariable int id) {
        topListService.delete(id);
        return "redirect:/admin/toplists.html";
    }

    @RequestMapping(value = "/rename/{id}", method = RequestMethod.POST)
    public String renameTopList(@PathVariable int id, @RequestParam(value = "name") String name) {
        topListService.rename(id, name);
        return "redirect:/admin/toplists.html";
    }

    @RequestMapping("/{title}/remove/book/{id}")
    public String removeBookFromToplist(@PathVariable int id, @PathVariable String title) {
        topListService.removeBook(title, id);
        return "redirect:/admin/toplists/{title}.html";
    }

}
