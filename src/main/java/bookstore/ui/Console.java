package bookstore.ui;

import bookstore.model.Book;

import bookstore.model.Client;
import bookstore.service.BookService;
import bookstore.service.ClientService;
import org.apache.commons.lang3.tuple.ImmutablePair;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Console {
    /**
     * The options available to the user.
     */
    private final List<ImmutablePair<String, String>> menuOptions = new ArrayList<>();
    private final BookService bookService;
    private final ClientService clientService;
    private Scanner scanner;


    /**
     * Constructor.
     *
     * @param bookService

     * @param clientService
     */
    public Console(BookService bookService, ClientService clientService) {
        this.scanner = new Scanner(System.in);
        this.bookService = bookService;
        this.clientService = clientService;
        buildMenu();
    }

    /**
     * Aggregates the menu options to display to the user.
     */
    private void buildMenu() {
        addMenuOption("Show books", "handleShowBooks");
        addMenuOption("Show clients", "handleShowClients");
        addMenuOption("Add client", "handleAddClient");
        addMenuOption("Exit", null);
    }

    /**
     * Adds an option to the menu.
     *
     * @param optionText The text to display to the user.
     * @param method     The name of the method that should be called when the user selects the option.
     */
    private void addMenuOption(String optionText, String method) {
        ImmutablePair<String, String> option = new ImmutablePair<>(optionText, method);
        menuOptions.add(option);
    }

    /**
     * Displays a menu of user options.
     */
    private void showMenu() {
        int i = 1;

        for (ImmutablePair<String, String> option : menuOptions) {
            System.out.println(i + ". " + option.getLeft());
            i++;
        }

        System.out.println("Your option: ");
    }

    /**
     * The method that should be called to get user input and execute commands based on it.
     */
    public void runConsole() {
        ImmutablePair<String, String> option;
        while (true) {
            showMenu();

            int userOption = Integer.parseInt(scanner.next()) - 1;

            try {
                option = menuOptions.get(userOption);
            } catch (Exception e) {
                System.out.println("No such option.");
                continue;
            }

            if (option == null) {
                System.out.println("We can't do that right now.");
                continue;
            }

            String methodName = option.getRight();

            if (methodName == null) {
                System.out.println("Exiting. Bye!");
                return;
            }

            try {
                Method method = this.getClass().getDeclaredMethod(methodName);
                method.invoke(this);
            } catch (Exception e) {
                System.out.println("We can't do that right now.");
            }
        }
    }

    /**
     * Will display the books that currently exist in the system.
     */
    private void handleShowBooks() {
        Collection<Book> books = bookService.findAllBooks();
        books.forEach(System.out::println);
    }

    /**
     * Will display the clients that currently exist in the system.
     */
    private void handleShowClients() {
        Collection<Client> clients = clientService.findAllClients();
        clients.forEach(System.out::println);
    }

    /**
     * Will add a client entry to the system. Displays a confirmation message.
     */
    private void handleAddClient(){
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Email address: ");
        String emailAddress = scanner.nextLine();
        clientService.add(firstName,lastName,emailAddress);
        //conditie: daca il gaseste in rep.
        System.out.println("Client entry created successfully.");
    }
}
