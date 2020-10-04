package bookstore.ui;

import bookstore.model.Book;
import bookstore.service.BookService;
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

    /**
     * Constructor.
     * @param bookService
     */
    public Console(BookService bookService) {
        this.bookService = bookService;
        buildMenu();
    }

    /**
     * Aggregates the menu options to display to the user.
     */
    private void buildMenu() {
        addMenuOption( "Show books", "handleShowBooks");
        addMenuOption("Exit", null);
    }

    /**
     * Adds an option to the menu.
     *
     * @param optionText The text to display to the user.
     * @param method The name of the method that should be called when the user selects the option.
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
        Scanner scanner = new Scanner(System.in);

        ImmutablePair<String, String> option;
        while (true) {
            System.out.println("=".repeat(50));
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
}
