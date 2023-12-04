package com.example.demo.model;

import java.util.Objects;

public class Book {
    private int id;
    private String title;

    private Author author;
    private double price;
    private int quantity;

    public Book() {

    }

    public Book(int id, String title, Author author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public Book(String title, Author author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getId() == book.getId() && Double.compare(getPrice(), book.getPrice()) == 0 && getQuantity() == book.getQuantity() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
