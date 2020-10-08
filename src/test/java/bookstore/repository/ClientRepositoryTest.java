package bookstore.repository;

import bookstore.model.AbstractEntity;
import bookstore.model.Client;
import bookstore.repository.storage.MemoryStorage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientRepositoryTest {
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        clientRepository = new ClientRepository(new MemoryStorage());
        clientRepository.save(new Client("Ronald","Friedman","rontr0n@email.com"));
        clientRepository.save(new Client("Chrissy","Missy","miss.chriss@email.com"));
        clientRepository.save(new Client("Alan","Klaus","alanklaus@email.com"));
    }

    @Test
    void findClientById_should_returnExistingClient() {
        Client c1 = (Client) clientRepository.findOne(Client.class, 1);
        Client c2 = (Client) clientRepository.findOne(Client.class, 2);
        Client c3 = (Client) clientRepository.findOne(Client.class, 3);
        assertEquals(1, c1.getId());
        assertEquals(2, c2.getId());
        assertEquals(3, c3.getId());
    }

    @Test
    void saveNewClient_should_updateDatabase() {
        int originalClientsCount = clientRepository.findAll(Client.class).size();
        Client newClient = new Client("Adam", "Ackerman","alack@gmail.com");
        clientRepository.save(newClient);

        int currentClientsCount = clientRepository.findAll(Client.class).size();
        assertEquals(currentClientsCount, originalClientsCount + 1);
    }

    @Test
    void deleteClient_should_deleteFromDatabase() {
        clientRepository.deleteById(Client.class, 1);
        Client c1 = (Client) clientRepository.findOne(Client.class, 1);
        Assert.assertNull(c1);
    }

    @Test
    void updateClient_should_updateDatabase() {
        Client c1 = (Client) clientRepository.findOne(Client.class, 1);
        c1.setFirstName("James");
        clientRepository.save(c1);
        Client updatedClient = (Client) clientRepository.findOne(Client.class, 1);
        assertEquals("James", updatedClient.getFirstName());
    }

    @Test
    void deleteNonExistentClient_should_throwException() {
        Client newClient = new Client("Adam", "Ackerman","alack@gmail.com");
        assertThrows(
                RuntimeException.class, () -> { clientRepository.delete(newClient); });
    }

    @Test
    void deleteEntity_should_deleteFromDatabase() {
        Client c1 = (Client) clientRepository.findOne(Client.class, 1);
        clientRepository.delete(c1);
    }

    @Test
    void findNonExistingEntityType_should_throwException() {
        assertThrows(
                RuntimeException.class, () -> { clientRepository.findOne(AbstractEntity.class, 1); });
    }
}
