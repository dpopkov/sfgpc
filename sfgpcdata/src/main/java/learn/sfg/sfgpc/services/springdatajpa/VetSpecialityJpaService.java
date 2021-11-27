package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.VetSpecialty;
import learn.sfg.sfgpc.repositories.VetSpecialtyRepository;
import learn.sfg.sfgpc.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.SPRING_DATA_JPA)
@Service
public class VetSpecialityJpaService extends AbstractJpaService<VetSpecialty> implements VetSpecialtyService {
    protected VetSpecialityJpaService(VetSpecialtyRepository vetSpecialtyRepository) {
        super(vetSpecialtyRepository);
    }
}
