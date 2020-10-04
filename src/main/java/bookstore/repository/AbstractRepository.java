package bookstore.repository;

import bookstore.model.AbstractEntity;
import bookstore.repository.storage.StorageInterface;

public class AbstractRepository implements RepositoryInterface {
    /**
     * The storage where the relevant data is kept.
     */
    protected final StorageInterface storage;

    public AbstractRepository(StorageInterface storage) {
        this.storage = storage;
    }

    @Override
    public AbstractEntity save(AbstractEntity entity) {
        return storage.save(entity);
    }

    @Override
    public AbstractEntity findOne(Class<? extends AbstractEntity> entityClass, int id) {
        return storage.findOne(entityClass, id);
    }

    @Override
    public Iterable<AbstractEntity> findAll(Class<? extends AbstractEntity> entityClass) {
        return storage.findAll(entityClass);
    }

    @Override
    public AbstractEntity delete(AbstractEntity entity) {
        if (entity.getId() == null) {
            throw new RuntimeException("Can't delete a new entity!");
        }

        return storage.delete(entity.getClass(), entity.getId());
    }

    @Override
    public AbstractEntity deleteById(Class<? extends AbstractEntity> entityClass, int id) {
        return storage.delete(entityClass, id);
    }
}
