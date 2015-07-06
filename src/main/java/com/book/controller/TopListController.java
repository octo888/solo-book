package com.book.controller;

import com.book.entity.TopList;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopListController {

    @Autowired
    private TopListService topListService;

    @RequestMapping("/admin/toplist")
    public String toplist(Model model) {
        model.addAttribute("toplist", topListService.findAll());
        return "toplist";
    }

    @RequestMapping("/admin/toplist/{title}")
    public String topListDetail(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneWithBooks(title));
        return "toplist-detail";
    }

    @RequestMapping(value = "/admin/toplist", method = RequestMethod.POST)
    public String doAddTopList(@ModelAttribute("toplist") TopList topList) {
        topListService.save(topList);
        return "redirect:/admin/toplist.html";
    }

    @RequestMapping("/admin/toplist/remove/{id}")
    public String removeTopList(@PathVariable int id) {
        topListService.delete(id);
        return "redirect:/admin/toplist.html";
    }
}
