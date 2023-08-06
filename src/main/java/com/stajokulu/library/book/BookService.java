package com.stajokulu.library.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void create(String isbn, String name, String author, Integer year) {
        Book book = new Book();
        book.setISBN(isbn);
        book.setName(name);
        book.setAuthor(author);
        book.setYear(year);

        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    } // sa
}
