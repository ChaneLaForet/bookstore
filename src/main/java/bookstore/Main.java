package bookstore;

import bookstore.model.Address;
import bookstore.model.Book;
import bookstore.model.Client;
import bookstore.repository.BookRepository;
import bookstore.repository.ClientRepository;
import bookstore.repository.storage.MemoryStorage;
import bookstore.repository.storage.StorageInterface;
import bookstore.service.BookService;
import bookstore.service.ClientService;
import bookstore.ui.Console;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StorageInterface storage = new MemoryStorage();
        BookRepository bookRepository = new BookRepository(storage);
        ClientRepository clientRepository = new ClientRepository(storage);
        BookService bookService = new BookService(bookRepository);
        ClientService clientService = new ClientService(clientRepository);

        addTestBookData(bookRepository);
        addTestClientData(clientRepository);

        Console console = new Console(bookService, clientService);
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
                        new ArrayList<String>() {{
                            add("Catherynne Valente");
                        }},
                        "Russian myth at its best.",
                        (float) 10.00
                )
        );

        bookRepository.save(
                new Book(
                        "Ask Baba Yaga",
                        new ArrayList<String>() {{
                            add("Taisia Kitaiskaia");
                        }},
                        "Go on, ask her.",
                        (float) 8.00
                ));

        bookRepository.save(
                new Book(
                        "You Look Like a Thing and I Love You",
                        new ArrayList<String>() {{
                            add("Janelle Shane");
                        }},
                        "Weird AI indeed.",
                        (float) 13.00
                ));
    }

    /**
     * Adds some client entries for testing.
     * @param clientRepository a repository for clients.
     */
    private static void addTestClientData(ClientRepository clientRepository){
        clientRepository.save(new Client("Ronald","Friedman","rontr0n@email.com"));
        clientRepository.save(new Client("Chrissy","Missy","miss.chriss@email.com"));
        clientRepository.save(new Client("Alan","Klaus","alanklaus@email.com"));

        Address a0 = new Address("Unirii", 25,"Cluj-Napoca","Cluj","Romania","49928");
        List<Address> addressList1 = new ArrayList<>();
        addressList1.add(a0);
        clientRepository.save(new Client("Roberta","Dumitru","alanklaus@email.com", addressList1));

        Address a1 = new Address("Abbey Road", 123,"London","London","England","85673");
        Address a2 = new Address("Piccadilly", 12,"London","London","England","83920");
        List<Address> addressList2 = new ArrayList<>();
        addressList2.add(a1);
        addressList2.add(a2);
        clientRepository.save(new Client("Hannah", "Porter","hannahporter@gmail.com", addressList2));
    }
}
