package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.model.BaseEntity;
import learn.sfg.sfgpc.services.BaseService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity> implements BaseService<T> {
    private long lastId;

    protected final Map<Long, T> map = new HashMap<>();

    private synchronized long nextId() {
        lastId++;
        return lastId;
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public T save(T object) {
        long id = nextId();
        object.setId(id);
        map.put(id, object);
        return object;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(T object) {
        deleteById(object.getId());
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    /** This getter is here for testing purposes. */
    Map<Long, T> getMap() {
        return Collections.unmodifiableMap(map);
    }
}
