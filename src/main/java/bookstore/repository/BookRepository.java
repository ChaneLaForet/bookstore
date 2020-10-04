package bookstore.repository;

import bookstore.repository.storage.StorageInterface;

/**
 * Concrete repository for books.
 */
public class BookRepository extends AbstractRepository
{
    public BookRepository(StorageInterface storage) {
        super(storage);
    }
}
