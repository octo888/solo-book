package com.book.service;

import com.book.entity.Blog;
import com.book.entity.User;
import com.book.repository.BlogRepository;
import com.book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setPublishedDate(new Date());
        blog.setUser(user);
        blogRepository.save(blog);
    }

    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }

    public List<Blog> findAll() {
        return blogRepository.findAll(new PageRequest(0, 5, Sort.Direction.DESC, "publishedDate")).getContent();
    }

    public Page<Blog> getBlogPage(int pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, 5, Sort.Direction.DESC, "publishedDate");
        return blogRepository.findAll(pageRequest);
    }
}
