package bookstore.repository;

import bookstore.model.Book;
import bookstore.repository.storage.MemoryStorage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class BookRepositoryTest {
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository(new MemoryStorage());

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

    @Test
    void findBookByIdShouldReturnExistingBook() {
        Book book = (Book) bookRepository.findOne(Book.class, 1);
        assertEquals(1, book.getId());
    }

    @Test
    void saveNewBookShouldUpdateDatabase() {
        int originalBooksCount = bookRepository.findAll(Book.class).size();

        bookRepository.save(
                new Book(
                        "The Haunting of Hill House",
                        new ArrayList<>() {{
                            add("Shirley Jackson");
                        }},
                        "Come get your cup of stars.",
                        (float) 23.00
                ));

        int currentBooksCount = bookRepository.findAll(Book.class).size();

        assertEquals(currentBooksCount, originalBooksCount + 1);
    }
}