package com.book.controller;

import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopListController {

    @Autowired
    private TopListService topListService;

    @RequestMapping("/admin/toplist")
    public String toplist(Model model) {
        model.addAttribute("toplist", topListService.findaAll());
        return "/admin/toplist";
    }

    @RequestMapping("/admin/toplist/{title}")
    public String topListDetail(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneWithBooks(title));
        return "/admin/toplist-detail";
    }
}
