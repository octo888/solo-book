package com.book.controller;

import com.book.service.NewsBlogService;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private NewsBlogService newsBlogService;

    @Autowired
    private TopListService topListService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("news", newsBlogService.getItemsForIndex());
        model.addAttribute("pluginImages", topListService.pluginImages());
        model.addAttribute("pluginLinks", topListService.pluginLinks());
        return "index";
    }

}
