package com.stajokulu.library.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/create")
    public void create (@RequestParam String ISBN,
                        @RequestParam String name,
                        @RequestParam String author,
                        @RequestParam Integer year) {
        bookService.create(ISBN, name, author, year);
    }
}
