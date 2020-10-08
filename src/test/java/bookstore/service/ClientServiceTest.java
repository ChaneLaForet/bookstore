package bookstore.service;

import bookstore.model.Client;
import bookstore.repository.ClientRepository;
import bookstore.repository.storage.MemoryStorage;
import bookstore.repository.storage.StorageInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceTest {
    private StorageInterface storage = new MemoryStorage();
    private ClientRepository clientRepository = new ClientRepository(storage);
    private ClientService clientService = new ClientService(clientRepository);

    @Test
    void  addingClients_should_addAllGivenClients() {
        Client c1 = new Client("Hannah", "Porter","hannahporter@gmail.com");
        Client c2 = new Client("Yumi", "Yamada","yumiYMD@hotmail.jp");
        Client c3 = new Client("Patricia", "Popa","patripopa@yahoo.ro");

        clientService.add(c1.getFirstName(),c1.getLastName(),c1.getEmailAddress());
        clientService.add(c2.getFirstName(),c2.getLastName(),c2.getEmailAddress());
        clientService.add(c3.getFirstName(),c3.getLastName(),c3.getEmailAddress());

        assertEquals(3, clientService.findAllClients().size());
        ArrayList clientList = new ArrayList(clientService.findAllClients());
        assertEquals(true, c1.equals(clientList.get(0)));
        assertEquals(true, c2.equals(clientList.get(1)));
        assertEquals(true, c3.equals(clientList.get(2)));
    }
}
