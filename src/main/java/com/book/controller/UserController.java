package com.book.controller;

import com.book.entity.User;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/admin/users/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findOne(id));
        return "user-detail";
    }


    @RequestMapping("/account")
    public String account(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("user", userService.findOneByName(name));
        return "user-account";
    }

    @RequestMapping("/admin/users/remove/{id}")
    public String removeUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/admin/users.html";
    }

}
