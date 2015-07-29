package com.book.service;


import com.book.entity.NewsItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class RssServiceTest {

    private RssService rssService;

    @Before
    public void setUp() throws Exception {

        rssService = new RssService();

    }

    @Test
    public void testName() throws Exception {

       /* List<NewsItem> items = rssService.getItems("https://www.bookbrowse.com/rss/book_news.rss");
        assertEquals(10, items.size());

        NewsItem item = items.get(1);
        assertEquals("Go Set a Watchman sells 1.1 million copies in North America in first week",
                item.getTitle());*/

    }
}
