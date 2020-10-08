package bookstore.model;

/**
 * Base class for entities.
 */
abstract public class AbstractEntity {
    /**
     * Unique identifier.
     */
    protected Integer id;

    /**
     * Sets the ID once.
     *
     * @param id The entity ID
     */
    public void setId(int id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}
