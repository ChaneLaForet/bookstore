package bookstore.repository.storage;

import bookstore.model.AbstractEntity;

/**
 * Basic operations that all storage types should implement.
 */
public interface StorageInterface {
    /**
     * Saves the given entity.
     */
    AbstractEntity save(AbstractEntity entity);

    /**
     * Finds one entity by ID.
     *
     * @param entityClass Class of the entity to find.
     */
    AbstractEntity findOne(Class<? extends AbstractEntity> entityClass, int id);

    /**
     * Finds all entities of type.
     *
     * @param entityClass Class of the entity to find.
     */
    Iterable<AbstractEntity> findAll(Class<? extends AbstractEntity> entityClass);

    /**
     * Deletes the given entity.
     */
    AbstractEntity delete(Class<? extends AbstractEntity> entityClass, int id);
}
