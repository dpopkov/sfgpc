package learn.sfg.sfgpc.services;

import java.util.Optional;
import java.util.Set;

public interface BaseService <T, ID> {

    Optional<T> findById(ID id);

    T save(T entity);

    Set<T> findAll();
}
