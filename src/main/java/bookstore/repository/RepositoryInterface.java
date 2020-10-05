package bookstore.repository;

import bookstore.model.AbstractEntity;

import java.util.Collection;

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
     *
     * @param entityClass Class of the entity to find.
     */
    AbstractEntity findOne(Class<? extends AbstractEntity> entityClass, int id);

    /**
     * Finds all entities of type.
     *
     * @param entityClass Class of the entity to find.
     */
    Collection<AbstractEntity> findAll(Class<? extends AbstractEntity> entityClass);

    /**
     * Deletes the given entity.
     */
    AbstractEntity delete(AbstractEntity entity);

    /**
     * Deletes the entity of the given class with the given ID.
     * @param entityClass Class of the entity to find.
     */
    AbstractEntity deleteById(Class<? extends AbstractEntity> entityClass, int id);
}
