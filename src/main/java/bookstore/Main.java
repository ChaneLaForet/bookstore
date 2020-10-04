package bookstore;

import bookstore.model.Book;
import bookstore.repository.BookRepository;
import bookstore.repository.storage.MemoryStorage;
import bookstore.repository.storage.StorageInterface;
import bookstore.service.BookService;
import bookstore.ui.Console;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StorageInterface storage = new MemoryStorage();
        BookRepository bookRepository = new BookRepository(storage);
        BookService bookService = new BookService(bookRepository);

        addTestBookData(bookRepository);

        Console console = new Console(bookService);
        console.runConsole();
    }

    /**
     * Adds some test books.
     *
     * @param bookRepository
     */
    private static void addTestBookData(BookRepository bookRepository) {
        bookRepository.save(
                new Book(
                        "Deathless",
                        new ArrayList<>() {{
                            add("Catherynne Valente");
                        }},
                        "Russian myth at its best.",
                        (float) 10.00
                )
        );

        bookRepository.save(
                new Book(
                        "Ask Baba Yaga",
                        new ArrayList<>() {{
                            add("Taisia Kitaiskaia");
                        }},
                        "Go on, ask her.",
                        (float) 8.00
                ));

        bookRepository.save(
                new Book(
                        "You Look Like a Thing and I Love You",
                        new ArrayList<>() {{
                            add("Janelle Shane");
                        }},
                        "Weird AI indeed.",
                        (float) 13.00
                ));
    }
}
