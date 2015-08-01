package com.book.repository;

import com.book.entity.ImageOfDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageOfDayRepository extends JpaRepository<ImageOfDay, Integer> {

}
