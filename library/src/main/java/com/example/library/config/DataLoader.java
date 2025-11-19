package com.example.library.config;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataLoader(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        bookRepository.deleteAll();
        authorRepository.deleteAll();

        // Create authors
        Author a1 = new Author(null, "J.K. Rowling", "jkrowling@example.com", "British author, Harry Potter series");
        Author a2 = new Author(null, "George R.R. Martin", "grrm@example.com", "American author, Game of Thrones series");
        Author a3 = new Author(null, "J.R.R. Tolkien", "tolkien@example.com", "British author, The Lord of the Rings series");

        authorRepository.save(a1);
        authorRepository.save(a2);
        authorRepository.save(a3);


        Book b1 = new Book(null, "Harry Potter and the Sorcerer's Stone", "978-0747532699", 1997, a1);
        Book b2 = new Book(null, "A Game of Thrones", "978-0553103540", 1996, a2);
        Book b3 = new Book(null, "The Hobbit", "978-0547928227", 1937, a3);

        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);

        System.out.println("Sample data loaded successfully!");
    }
}
