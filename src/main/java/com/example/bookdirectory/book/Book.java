package com.example.bookdirectory.book;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document
public class Book {

    @Id
    private Integer id;


    private String title;

   private String imageUri;

   private Date dateOfPublication = new Date();

  private List<String> chapter = new ArrayList<>();

   private float price;


    public Book() {
    }

    public Book(Integer id, String title, String imageUri, Date dateOfPublication, List<String> chapter, float price) {
        this.id = id;
        this.title = title;
        this.imageUri = imageUri;
        this.dateOfPublication = dateOfPublication;
        this.chapter = chapter;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public List<String> getChapter() {
        return chapter;
    }

    public void setChapter(List<String> chapter) {
        this.chapter = chapter;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
