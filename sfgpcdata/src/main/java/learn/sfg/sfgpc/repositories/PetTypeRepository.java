package learn.sfg.sfgpc.repositories;

import learn.sfg.sfgpc.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
