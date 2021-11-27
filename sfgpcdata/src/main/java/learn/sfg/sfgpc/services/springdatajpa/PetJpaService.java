package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Pet;
import learn.sfg.sfgpc.repositories.PetRepository;
import learn.sfg.sfgpc.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.SPRING_DATA_JPA)
@Service
public class PetJpaService extends AbstractJpaService<Pet> implements PetService {
    protected PetJpaService(PetRepository petRepository) {
        super(petRepository);
    }
}
