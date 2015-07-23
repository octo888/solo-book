package com.book.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "toplist")
public class TopList {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String title;

    @ManyToMany(fetch = FetchType.EAGER) /*(mappedBy = "topLists", cascade = CascadeType.MERGE) оставлю для напоминания*/
    private Map<Integer, Book> books;

    public TopList() {
    }

    public TopList(String name, String title) {
        this.name = name;
        this.title = title;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }


}
