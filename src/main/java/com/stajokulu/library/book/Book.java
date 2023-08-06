package com.stajokulu.library.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Book {

    @Id
    private String ISBN;

    private String name;

    private String author;

    private Integer year;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, name, author, year);
    }
}
