package com.book.service;

import com.book.entity.Image;
import com.book.entity.ImageOfDay;
import com.book.repository.ImageOfDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ImageOfDayService {

    @Autowired
    private ImageOfDayRepository imageOfDayRepository;

    public List<ImageOfDay> findAll() {
        return imageOfDayRepository.findAll();
    }

    public List<ImageOfDay> getDaysImages() {
        return imageOfDayRepository.findAll(new PageRequest(0, 5, Sort.Direction.DESC, "pubDate")).getContent();
    }

    public void save(String name, MultipartFile image, HttpServletResponse response) {
        try {
            ImageOfDay imageOfDay = new ImageOfDay();
            imageOfDay.setName(name);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = sdf.format(date);

            imageOfDay.setPubDate(date);
            imageOfDay.setFormattedDate(formattedDate);

            imageOfDay.setImage(image.isEmpty() ? null : new Image(image.getOriginalFilename(), image.getBytes()));
            imageOfDayRepository.save(imageOfDay);

        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(Integer id) {
        imageOfDayRepository.delete(id);
    }


}
