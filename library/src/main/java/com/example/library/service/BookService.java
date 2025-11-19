package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(Book book, Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book newData, Long authorId) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(newData.getTitle());
            book.setIsbn(newData.getIsbn());
            book.setPublished(newData.getPublished());

            Author author = authorRepository.findById(authorId).orElse(null);
            book.setAuthor(author);

            return bookRepository.save(book);
        }).orElse(null);
    }
}
