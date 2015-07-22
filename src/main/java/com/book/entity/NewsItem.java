package com.book.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NewsItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1000)
    private String title;

    @Lob
    @Type(type = "org.hibernate.type.StringClobType")
    @Column(length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "published_date")
    private Date publishedDate;

    @Column(length = 1000)
    private String link;

    @ManyToOne
    @JoinColumn(name = "newsblog_id")
    private NewsBlog newsBlog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public NewsBlog getNewsBlog() {
        return newsBlog;
    }

    public void setNewsBlog(NewsBlog newsBlog) {
        this.newsBlog = newsBlog;
    }
}
