package com.book.controller;

import com.book.entity.Book;
import com.book.repository.TopListRepository;
import com.book.service.ImageOfDayService;
import com.book.service.NewsBlogService;
import com.book.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private NewsBlogService newsBlogService;

    @Autowired
    private TopListRepository topListRepository;

    @Autowired
    private ImageOfDayService imageOfDayService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("news", newsBlogService.getItemsForIndex());
        model.addAttribute("dayImage", imageOfDayService.getDaysImages());
        return "index";
    }

    @RequestMapping(value = "/plugin")
    @ResponseBody
    public List<BookWrap> getPluginContent() {
        Map<Integer, Book> map = topListRepository.findOneByTitle("topmonth").getBooks();
        List<Book> books = new ArrayList<>(map.values());
        List<BookWrap> list = new ArrayList<>();

        for (Book book : books) {
            BookWrap bookWrap = new BookWrap();
            bookWrap.setBookID("/" + book.getId() + ".html");
            bookWrap.setImageID("/image/" + book.getImage().getId() + ".html");
            list.add(bookWrap);
        }

        return list;
    }

    private class BookWrap {
        private String bookID;
        private String imageID;

        public String getBookID() {
            return bookID;
        }

        public void setBookID(String bookID) {
            this.bookID = bookID;
        }

        public String getImageID() {
            return imageID;
        }

        public void setImageID(String imageID) {
            this.imageID = imageID;
        }
    }


}
