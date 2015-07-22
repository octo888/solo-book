package com.book.repository;

import com.book.entity.NewsBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsBlogRepository extends JpaRepository<NewsBlog, Long> {
}
