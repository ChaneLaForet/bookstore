package bookstore.repository.storage;

import bookstore.model.AbstractEntity;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Stores given data in memory.
 */
public class MemoryStorage implements StorageInterface {
    /*
     * Will hold entries like:
     * {
     *   123456 => { 1 => book 1, 2 => book 2, 3 => book 3 },
     *   789124 => { 1 => customer 1, 2 => customer 2, 3 => customer 3 }
     * }
     *
     * The integer key in the main map is the hash code of the class of the objects in the nested map.
     * E.g. for the books map, the key is the hash code of the Book class.
     * We're using a navigable map because we need the entries to be sorted by ID.
     */
    private final Map<Integer, NavigableMap<Integer, AbstractEntity>> database = new HashMap<>();

    /**
     * @param entityClass A concrete entity.
     * @return Unique identifier where entities of this type will be stored.
     */
    private int getCodeForClass(Class<? extends AbstractEntity> entityClass) {
        return entityClass.hashCode();
    }

    @Override
    public AbstractEntity save(@NotNull AbstractEntity entity) {
        // add new map entry for this entity if there is none so far.
        NavigableMap<Integer, AbstractEntity> entityMap = database.computeIfAbsent(
                getCodeForClass(entity.getClass()),
                k -> new TreeMap<>()
        );

        // add/overwrite data for the given id
        if (entity.getId() != null) {
            entityMap.put(entity.getId(), entity);
            return entity;
        }

        // add new data with the id following the last one in the map
        Map.Entry<Integer, AbstractEntity> lastEntry = entityMap.lastEntry();
        int lastId = lastEntry == null ? 0 : lastEntry.getValue().getId();
        entity.setId(lastId + 1);
        entityMap.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public AbstractEntity findOne(Class<? extends AbstractEntity> entityClass, int id) {
        Map<Integer, AbstractEntity> entityMap = database.get(getCodeForClass(entityClass));

        if (entityMap == null) {
            throw new RuntimeException("Such entities are not stored here.");
        }

        return entityMap.get(id);
    }

    @Override
    public AbstractEntity delete(Class<? extends AbstractEntity> entityClass, int id) {
        Map<Integer, AbstractEntity> entityMap = database.get(getCodeForClass(entityClass));

        if (entityMap == null) {
            throw new RuntimeException("Such entities are not stored here.");
        }

        return entityMap.remove(id);
    }

    @Override
    public Collection<AbstractEntity> findAll(Class<? extends AbstractEntity> entityClass) {
        Map<Integer, AbstractEntity> entityMap = database.get(getCodeForClass(entityClass));

        if (entityMap == null) {
            throw new RuntimeException("Such entities are not stored here.");
        }

        return new ArrayList<>(entityMap.values());
    }

    // TODO find by field
}
