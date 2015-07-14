package com.book.entity;

import javax.persistence.*;

@Entity
public class Rate {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer rate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
