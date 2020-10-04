package bookstore.repository;

import bookstore.model.AbstractEntity;

/**
 * Interface for CRUD operations on entities.
 */
public interface RepositoryInterface {
    /**
     * @param entity The entity to save.
     */
    AbstractEntity save(AbstractEntity entity);

    /**
     * Finds one entity by ID.
     * @param entityClass Class of the entity to find.
     * @param id The entity ID.
     */
    AbstractEntity findOne(Class<? extends AbstractEntity> entityClass, int id);

    Iterable<AbstractEntity> findAll(Class<? extends AbstractEntity>entityClass);

    AbstractEntity delete(AbstractEntity entity);

    AbstractEntity deleteById(Class<? extends AbstractEntity> entityClass, int id);
}
