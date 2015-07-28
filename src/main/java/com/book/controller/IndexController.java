package com.book.controller;


import com.book.entity.Book;
import com.book.service.CategoryService;
import com.book.service.NewsBlogService;
import com.book.service.TopListService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NewsBlogService newsBlogService;

    @Autowired
    private TopListService topListService;

    private final String TOPLIST_FOR_CAROUSEL = "toptwentymonth";

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("news", newsBlogService.getItemsForIndex());
        model.addAttribute("pluginImages", pluginImages());
        model.addAttribute("pluginLinks", pluginLinks());
        return "index";
    }

    public String pluginImages() {
        Map<Integer, Book> map = topListService.findOneByTitle(TOPLIST_FOR_CAROUSEL).getBooks();
        List<Book> books = new ArrayList<>(map.values());
        List<String> list = new ArrayList<>();
        for (Book book : books) {
            list.add("/image/" + book.getImage().getId() + ".html");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String pluginLinks() {
        Map<Integer, Book> map = topListService.findOneByTitle(TOPLIST_FOR_CAROUSEL).getBooks();
        List<Book> books = new ArrayList<>(map.values());
        List<String> list = new ArrayList<>();
        for (Book book : books) {
            list.add("/" + book.getId() + ".html");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
