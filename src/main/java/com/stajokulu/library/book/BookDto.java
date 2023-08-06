package com.stajokulu.library.book;

public class BookDto {

    private String name;

    private String author;

    private Integer year;

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

    public static BookDto create(String name, String author, Integer year){
        BookDto bookDto = new BookDto();
        bookDto.setName(name);
        bookDto.setAuthor(author);
        bookDto.setYear(year);

        return bookDto;
    }
}
