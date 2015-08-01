package com.book.controller;

import com.book.service.ImageOfDayService;
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

    @Autowired
    private ImageOfDayService imageOfDayService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("news", newsBlogService.getItemsForIndex());
        model.addAttribute("dayImage", imageOfDayService.getDaysImages());
        model.addAttribute("pluginImages", topListService.getPluginImages());
        model.addAttribute("pluginLinks", topListService.getPluginLinks());
        return "index";
    }

}
