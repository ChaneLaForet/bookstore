package bookstore.service;

import bookstore.model.Client;
import bookstore.model.validator.ClientValidator;
import bookstore.repository.ClientRepository;
import bookstore.repository.storage.MemoryStorage;
import bookstore.repository.storage.StorageInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientServiceTest {
    private final StorageInterface storage = new MemoryStorage();
    private final ClientRepository clientRepository = new ClientRepository(storage);
    private final ClientService clientService = new ClientService(clientRepository, new ClientValidator());

    @Test
    void  addingClients_should_addAllGivenClients() {
        Client c1 = new Client("Hannah", "Porter","hannahporter@gmail.com");
        Client c2 = new Client("Yumi", "Yamada","yumiYMD@hotmail.jp");
        Client c3 = new Client("Patricia", "Popa","patripopa@yahoo.ro");

        clientService.add(c1.getFirstName(),c1.getLastName(),c1.getEmailAddress());
        clientService.add(c2.getFirstName(),c2.getLastName(),c2.getEmailAddress());
        clientService.add(c3.getFirstName(),c3.getLastName(),c3.getEmailAddress());

        assertEquals(3, clientService.findAllClients().size());
        ArrayList<Client> clientList = new ArrayList<>(clientService.findAllClients());
        assertEquals(clientList.get(0), c1);
        assertEquals(clientList.get(1), c2);
        assertEquals(clientList.get(2), c3);
    }
}
