package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/{authorId}")
    public Book create(@PathVariable Long authorId, @RequestBody Book book) {
        return bookService.createBook(book, authorId);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}/{authorId}")
    public Book update(@PathVariable Long id,
                       @PathVariable Long authorId,
                       @RequestBody Book book) {
        return bookService.updateBook(id, book, authorId);
    }
}
