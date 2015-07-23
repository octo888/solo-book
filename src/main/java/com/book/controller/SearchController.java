package com.book.controller;


import com.book.entity.Book;
import com.book.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value = "pattern") String pattern, Model model) {
        List<Book> books = searchService.findBooksByPattern(pattern);
        model.addAttribute("result", books);
        if (books.isEmpty()) {
            model.addAttribute("error", true);
        }
        return "search-result";
    }
}
