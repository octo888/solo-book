package com.book.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<BlogItem> blogItems;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BlogItem> getBlogItems() {
        return blogItems;
    }

    public void setBlogItems(List<BlogItem> blogItems) {
        this.blogItems = blogItems;
    }
}
