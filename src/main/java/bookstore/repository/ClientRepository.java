package bookstore.repository;

import bookstore.repository.storage.StorageInterface;

/**
 * Concrete repository for clients.
 */
public class ClientRepository extends AbstractRepository {

    public ClientRepository(StorageInterface storage) {
        super(storage);
    }
}
