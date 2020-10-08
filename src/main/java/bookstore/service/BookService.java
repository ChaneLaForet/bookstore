package bookstore.service;

import bookstore.model.Book;
import bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    /**
     * @return All the books in the system.
     */
    public Collection<Book> findAllBooks() {
        Collection<Book> books = new ArrayList<>();
        repository.findAll(Book.class).forEach(e ->
                books.add((Book) e)
        );

        return books;
    }
}
