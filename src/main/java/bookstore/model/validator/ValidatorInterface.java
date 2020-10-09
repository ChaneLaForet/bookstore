package bookstore.model.validator;

import bookstore.model.AbstractEntity;

public interface ValidatorInterface<E extends AbstractEntity> {
    void validate(E entity);
}
