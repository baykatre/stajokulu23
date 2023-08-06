package com.stajokulu.library.book;

public class BookMapper {

    public static Book mapToBook(BookDto bookDto){
        Book book = new Book();

        book.setName(bookDto.name());
        book.setAuthor(bookDto.author());
        book.setYear(bookDto.year());

        return book;
    }

    public static BookDto mapToBookDto(Book book){
        return new BookDto(book.getName(), book.getAuthor(), book.getYear());
    }
}
