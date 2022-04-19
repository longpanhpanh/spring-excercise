package vn.techmaster.ex01.controllers;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.ex01.dto.BookRequest;
import vn.techmaster.ex01.model.Book;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("LL-24", new Book("LL-24", "A Book Title", "Long", 2022));
        books.put("PP-24", new Book("PP-24", "Second Book Title", "Panh", 2021));

    }

    @GetMapping
    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    @PostMapping
    public Book createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);

        return newBook;
    }


}
