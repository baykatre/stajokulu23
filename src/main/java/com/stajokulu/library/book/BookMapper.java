package com.stajokulu.library.book;

public class BookMapper {

    public static Book mapToBook(BookDto bookDto){
        Book book = new Book();

        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setYear(bookDto.getYear());

        return book;
    }

    public static BookDto mapToBookDto(Book book){
        BookDto bookDto = new BookDto();

        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setYear(book.getYear());

        return bookDto;
    }
}
