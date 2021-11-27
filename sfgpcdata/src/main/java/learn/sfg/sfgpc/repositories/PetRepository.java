package learn.sfg.sfgpc.repositories;

import learn.sfg.sfgpc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
