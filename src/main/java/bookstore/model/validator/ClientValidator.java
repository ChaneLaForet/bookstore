package bookstore.model.validator;

import bookstore.exception.DataValidationException;
import bookstore.model.Client;

import java.util.ArrayList;

/**
 * Validates a client entity.
 */
public class ClientValidator implements ValidatorInterface<Client> {
    @Override
    public void validate(Client entity) {
        ArrayList<String> messages = new ArrayList<>();

        if(entity.getFirstName().isEmpty() || entity.getFirstName() == null){
            messages.add("A client must have a first name!");
        }
        if(entity.getLastName().isEmpty() || entity.getLastName() == null){
            messages.add("A client must have a last name!");
        }
        if(entity.getEmailAddress().isEmpty() || entity.getEmailAddress() == null){
            messages.add("A client must have an associated email address!");
        }
        if(!entity.getEmailAddress().isEmpty() && !entity.getEmailAddress().contains("@")){     //TODO: proper email validation (pattern+unique)
            messages.add("Invalid email address; must contain '@'!");
        }
        if (messages.size() == 0) {
            return;
        }
        throw new DataValidationException(messages.toString());
    }
}
