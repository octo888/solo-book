package com.book.service;

import com.book.entity.Blog;
import com.book.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void save(Blog blog, String name) {

    }

    public void delete(Blog blog) {

    }

    public Blog findOne(int id) {
        return null;
    }
}
