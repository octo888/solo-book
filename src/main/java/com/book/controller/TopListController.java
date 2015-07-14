package com.book.controller;

import com.book.entity.TopList;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopListController {

    @Autowired
    private TopListService topListService;

    @ModelAttribute("toplist")
    public TopList constructToplist(){
        return new TopList();
    }

    @RequestMapping("/admin/toplists")
    public String toplist(Model model) {
        model.addAttribute("toplists", topListService.findAll());
        return "toplists";
    }

    @RequestMapping("/admin/toplists/{title}")
    public String topListDetail(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneWithBooks(title));
        return "toplist-detail";
    }

    @RequestMapping(value = "/admin/toplists", method = RequestMethod.POST)
    public String doAddTopList(@ModelAttribute("toplist") TopList topList) {
        topListService.save(topList);
        return "redirect:/admin/toplists.html";
    }

    @RequestMapping("/admin/toplists/remove/{id}")
    public String removeTopList(@PathVariable int id) {
        topListService.delete(id);
        return "redirect:/admin/toplists.html";
    }

    @RequestMapping(value = "/admin/toplists/rename/{id}", method = RequestMethod.POST)
    public String renameTopList(@PathVariable int id, @RequestParam(value = "name") String name) {
        topListService.rename(id, name);
        return "redirect:/admin/toplists.html";
    }
}
