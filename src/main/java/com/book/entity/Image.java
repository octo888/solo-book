package com.book.entity;

import org.hibernate.annotations.Type;

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
    //@Type(type = "org.hibernate.type.BinaryType")
    private byte[] body;

    public Image() {

    }

    public Image(String name, byte[] body) {
        this.name = name;
        this.body = body;
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

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

}
