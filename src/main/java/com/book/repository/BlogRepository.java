package com.book.repository;

import com.book.entity.Blog;
import com.book.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByUser(User user, Pageable pageable);


}
