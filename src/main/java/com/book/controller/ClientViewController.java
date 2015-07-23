package com.book.controller;


import com.book.entity.Book;
import com.book.service.CategoryService;
import com.book.service.NewsBlogService;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientViewController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TopListService topListService;

    @Autowired
    private NewsBlogService newsBlogService;

    @RequestMapping("/category/{title}")
    public String category(Model model, @PathVariable String title) {
        return getCategoryWithPageBook(1, title, model);
    }

    @RequestMapping(value = "/category/{title}/page/{pageNumber}", method = RequestMethod.GET)
    public String getCategoryWithPageBook(@PathVariable Integer pageNumber,
                                       @PathVariable String title,
                                       Model model) {
        Page<Book> page = categoryService.getPageWithBooks(title, pageNumber);
        List<Book> books = page.getContent();
        model.addAttribute("books", books);
        model.addAttribute("category", categoryService.findOneByTitle(title));

        int current = page.getNumber() + 1;
        int begin = 1;//Math.max(1, current - 2);
        int end = page.getTotalPages();//Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("current", current);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);

        return "category";
    }

    @RequestMapping("/toplists")
    public String allToplists(Model model) {
        model.addAttribute("toplists", topListService.findAll());
        return "toplists";
    }

    @RequestMapping("/toplist/{title}")
    public String toplist(Model model, @PathVariable String title) {
        model.addAttribute("toplist", topListService.findOneByTitle(title));
        return "toplist";
    }

    @RequestMapping("/news")
    public  String news(Model model) {
        model.addAttribute("news", newsBlogService.getItems());
        return "news";
    }

}
