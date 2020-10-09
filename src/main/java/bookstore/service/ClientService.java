package bookstore.service;


import bookstore.model.Address;
import bookstore.model.Client;
import bookstore.model.validator.ClientValidator;
import bookstore.repository.ClientRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ClientService {

    private final ClientRepository repository;
    private ClientValidator validator;

    /**
     * The constructor for the Client Service.
     * @param repository a repository associated with the client service.
     */
    public ClientService(ClientRepository repository, ClientValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    /**
     * @return Returns all the clients in the system.
     */
    public Collection<Client> findAllClients() {
        Collection<Client> clients = new ArrayList<>();
        repository.findAll(Client.class).forEach(e ->
                clients.add((Client) e));

        return clients;
    }

    /**
     * Adds a client to the system.
     * @param firstName the client's first name.
     * @param lastName the client's last name.
     * @param emailAddress the client's email address.
     */
    public Client add(String firstName, String lastName, String emailAddress) {
        Client client = new Client(firstName, lastName, emailAddress);
        return (Client) repository.save(client);
    }
}
