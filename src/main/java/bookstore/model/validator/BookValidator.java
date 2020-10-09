package bookstore.model.validator;

import bookstore.exception.DataValidationException;
import bookstore.model.Book;

import java.util.ArrayList;

/**
 * Validates a book entity.
 *
 * A book must have a title, at least one author, and a non-zero price.
 */
public class BookValidator implements ValidatorInterface<Book> {
    @Override
    public void validate(Book entity) {
        ArrayList<String> messages = new ArrayList<>();

        if (entity.getTitle().isEmpty()) {
            messages.add("A book must have a title!");
        }

        if (entity.getAuthors().isEmpty()) {
            messages.add("A book must have at least one author!");
        }

        if (entity.getPrice() <= 0) {
            messages.add("A book must have a non-zero price!");
        }

        if (messages.size() == 0) {
            return;
        }

        throw new DataValidationException(messages.toString());
    }
}
