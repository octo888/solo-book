package com.book.controller;

import com.book.entity.Image;
import com.book.entity.ImageOfDay;
import com.book.service.ImageOfDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/day-image")
public class ImageOfDayController {

    @Autowired
    private ImageOfDayService imageOfDayService;

    @RequestMapping
    public String showAddImageOfDay(Model model) {
        model.addAttribute("dayImage", imageOfDayService.findAll());
        return "day-image";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAddImageOfDay(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "image") MultipartFile image,
                                  HttpServletResponse response) {
        imageOfDayService.save(name, image, response);
        return "redirect:/admin/day-image.html";
    }

    @RequestMapping("/remove/{id}")
    public String removeImageOfDay(@PathVariable Integer id) {
        imageOfDayService.delete(id);
        return "redirect:/admin/day-image.html";
    }
}
