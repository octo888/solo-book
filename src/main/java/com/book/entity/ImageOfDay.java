package com.book.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "day_image")
public class ImageOfDay {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(name = "published_date")
    private Date pubDate;

    @Column(name = "formatted_date")
    private String formattedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date publishedDate) {
        this.pubDate = publishedDate;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }
}
