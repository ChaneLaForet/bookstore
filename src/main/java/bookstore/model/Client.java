package bookstore.model;

import java.util.List;
import java.util.Objects;

/**
 * Represents a client.
 */
public class Client extends AbstractEntity {
    String firstName, lastName, emailAddress;
    List<Address> clientAddresses;

    public Client(String firstName, String lastName, String emailAddress, List<Address> clientAddresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.clientAddresses = clientAddresses;
    }

    public Client(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Address> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<Address> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    @Override
    public String toString() {
        return "Client #" + id + " named " + firstName + " " + lastName +
                " with email " + emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getFirstName().equals(client.getFirstName()) &&
                getLastName().equals(client.getLastName()) &&
                getEmailAddress().equals(client.getEmailAddress()) &&
                Objects.equals(getClientAddresses(), client.getClientAddresses());
    }
}
