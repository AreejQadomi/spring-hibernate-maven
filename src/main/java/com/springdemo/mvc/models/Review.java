package com.springdemo.mvc.models;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String comment;

    // We don't add a property for the foreign key column


    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
