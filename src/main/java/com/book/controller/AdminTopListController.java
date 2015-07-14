package com.book.controller;

import com.book.entity.TopList;
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

    @ModelAttribute("toplist")
    public TopList constructToplist(){
        return new TopList();
    }


    @RequestMapping
    public String toplist(Model model) {
        model.addAttribute("toplists", topListService.findAll());
        return "toplists";
    }

    @RequestMapping("/{title}")
    public String topListDetail(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneWithBooks(title));
        return "toplist-detail";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doAddTopList(@ModelAttribute("toplist") TopList topList) {
        topListService.save(topList);
        return "redirect:/admin/toplists.html";
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


}
