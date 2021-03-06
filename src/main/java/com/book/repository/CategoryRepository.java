package com.book.repository;

import com.book.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findOneByTitle(String title);

    Category findOneByName(String categoryName);
}
