package com.shivanshpachnanda.SampleSpringRestAPI.books.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity @Table @SuppressWarnings("unused")
public class Books_Entity {
    @Id @NotNull
    int id;

    @Column @NotNull
    String name;

    @Column @NotNull
    String author;

    @Column @NotNull @Positive
    int price;

    public Books_Entity(){}

    public Books_Entity(int id, String name, String author, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Object getFieldString(String order) throws NoSuchFieldException, IllegalAccessException {
        return this.getClass().getField("order").get(this);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Books_Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
