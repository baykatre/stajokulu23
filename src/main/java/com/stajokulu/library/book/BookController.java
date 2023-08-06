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
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/create-body/{isbn}")
    public String create(@RequestBody BookDto bookDto, @PathVariable String isbn) {
        return bookService.create(bookDto, isbn);
    }

    @PutMapping("/{isbn}")
    public String update(@RequestBody BookDto bookDto, @PathVariable String isbn) {
        return bookService.update(bookDto, isbn);
    }

    @DeleteMapping("/{isbn}")
    public String delete(@PathVariable String isbn) {
        return bookService.delete(isbn);
    }
}
