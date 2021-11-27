package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.PetType;
import learn.sfg.sfgpc.repositories.PetTypeRepository;
import learn.sfg.sfgpc.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.SPRING_DATA_JPA)
@Service
public class PetTypeJpaService extends AbstractJpaService<PetType> implements PetTypeService {
    protected PetTypeJpaService(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
    }
}
