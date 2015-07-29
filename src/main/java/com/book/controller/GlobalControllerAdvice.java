package com.book.controller;

import com.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private CategoryService categoryService;


    @ModelAttribute
    public void globalAttributes(Model model) {
        model.addAttribute("globalCategories", categoryService.findAll());
    }

    /*@ExceptionHandler(Exception.class)
    public ModelAndView myError(Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.setViewName("error");
        return mav;
    }*/
}
