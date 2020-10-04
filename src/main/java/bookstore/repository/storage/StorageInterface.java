package bookstore.repository.storage;

import bookstore.model.AbstractEntity;

/**
 * Basic operations that all storage types should implement.
 */
public interface StorageInterface {
    AbstractEntity save(AbstractEntity entity);

    AbstractEntity findOne(Class<? extends AbstractEntity> entityClass, int id);

    AbstractEntity delete(Class<? extends AbstractEntity> entityClass, int id);

    Iterable<AbstractEntity> findAll(Class<? extends AbstractEntity> entityClass);
}
