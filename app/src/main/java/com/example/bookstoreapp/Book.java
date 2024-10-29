package com.example.bookstoreapp;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private double price;
    private int image;

    public Book(String title, String author, double price, int image) {
        if (title == null || author == null || price < 0) {
            throw new IllegalArgumentException("Invalid book data");
        }
        this.title = title;
        this.author = author;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", image=" + image +
                '}';
    }
}
