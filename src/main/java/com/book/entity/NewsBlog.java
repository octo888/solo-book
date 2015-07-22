package com.book.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class NewsBlog {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 1, message = "Неверный URL!")
    @URL(message = "Введите корректный URL!")
    @Column(length = 1000)
    private String url;

    @Size(min = 1, message = "Название должно быть минимум 1 символ")
    private String name;

    @OneToMany(mappedBy = "newsBlog", cascade = CascadeType.REMOVE)
    private List<NewsItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NewsItem> getItems() {
        return items;
    }

    public void setItems(List<NewsItem> items) {
        this.items = items;
    }
}
