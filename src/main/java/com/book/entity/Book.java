package com.book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String authorName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinColumn(name = "toplist_id")
    private List<TopList> topLists;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;


    private List<Integer> rates = new ArrayList<>();

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorFirstName) {
        this.authorName = authorFirstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<TopList> getTopLists() {
        return topLists;
    }

    public void setTopLists(List<TopList> topLists) {
        this.topLists = topLists;
    }

    public List<Integer> getRates() {
        return rates;
    }

    public void setRates(List<Integer> rates) {
        this.rates = rates;
    }
}
