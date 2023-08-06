package com.stajokulu.library.book;

import com.stajokulu.library.exception.BookNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String create(BookDto bookDto, String ISBN) {

        Book existBook = bookRepository.findById(ISBN).orElse(null);

        if (Objects.nonNull(existBook)) {
            throw new RuntimeException("Aynı ISBN ile başka bir kitap var, ekleme işlemi yapılamaz!");
        }

        Book book = BookMapper.mapToBook(bookDto);

        book.setISBN(ISBN);

        Book savedBook = bookRepository.save(book);

        return "Kitap başarılı bir şekilde kaydedildi. ISBN: " + savedBook.getISBN();
    }

    public List<BookDto> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();

        if (CollectionUtils.isEmpty(bookList)){
            throw new BookNotFoundException("Şu anda hiçbir kitap yok!");
        }

        return bookList.stream().map(book -> BookMapper.mapToBookDto(book)).toList();
    }

    //Yukarıdaki bunun Stream'li hali
    private static List<BookDto> getBookDtos(List<Book> bookList) {

        List<BookDto> bookDtoList = new ArrayList<>();

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            BookDto bookDto = BookMapper.mapToBookDto(book);
            bookDtoList.add(bookDto);
        }

        return bookDtoList;
    }

    public String delete(String isbn) {

        Book existBook = bookRepository.findById(isbn).orElse(null);

        if (Objects.isNull(existBook)) {
            throw new BookNotFoundException("Böyle bir kitap yok, silme işlemi yapılamadı!");
        }

        bookRepository.deleteById(isbn);

        return "Kitap başarılı bir şekilde silindi. ISBN: " + isbn;
    }

    public String update(BookDto bookDto, String isbn) {

        Book existBook = bookRepository.findById(isbn).orElse(null);

        if (Objects.isNull(existBook)) {
            throw new BookNotFoundException("Böyle bir kitap yok, güncelleme işlemi yapılamadı!");
        }

        Book updatedBook = BookMapper.mapToBook(bookDto);

        updatedBook.setISBN(isbn);
        bookRepository.save(updatedBook);

        return "Kitap başarılı bir şekilde güncellendi. ISBN: " + isbn;
    }
}
