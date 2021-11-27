package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.model.BaseEntity;
import learn.sfg.sfgpc.services.BaseService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractJpaService<T extends BaseEntity> implements BaseService<T> {
    protected final CrudRepository<T, Long> crudRepository;

    protected AbstractJpaService(CrudRepository<T, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Optional<T> findById(Long id) {
        return crudRepository.findById(id);
    }

    @Override
    public T save(T object) {
        return crudRepository.save(object);
    }

    @Override
    public Set<T> findAll() {
        final HashSet<T> set = new HashSet<>();
        final Iterable<T> all = crudRepository.findAll();
        all.forEach(set::add);
        return set;
    }

    @Override
    public void delete(T object) {
        crudRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}
