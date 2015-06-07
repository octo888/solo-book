package com.book.entity;

import javax.persistence.*;

@Entity
@Table(name = "Images")
public class Image {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private byte[] body;

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

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
