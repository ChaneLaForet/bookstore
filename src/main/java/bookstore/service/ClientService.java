package bookstore.service;


import bookstore.model.Address;
import bookstore.model.Client;
import bookstore.repository.ClientRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ClientService {

    private final ClientRepository repository;

    /**
     * The constructor for the Client Service.
     * @param repository a repository associated with the client service.
     */
    public ClientService(ClientRepository repository) {
        this.repository = repository;
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
    public void add(String firstName, String lastName, String emailAddress) {
        Client client = new Client(firstName, lastName, emailAddress);
        repository.save(client);
    }
}
