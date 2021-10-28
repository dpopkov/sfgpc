package learn.sfg.sfgpc.services;

import learn.sfg.sfgpc.model.BaseEntity;

import java.util.Optional;
import java.util.Set;

public interface BaseService <T extends BaseEntity> {

    Optional<T> findById(Long id);

    T save(T entity);

    Set<T> findAll();
}
