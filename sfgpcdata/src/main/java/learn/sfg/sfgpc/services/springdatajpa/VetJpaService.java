package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Vet;
import learn.sfg.sfgpc.repositories.VetRepository;
import learn.sfg.sfgpc.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.SPRING_DATA_JPA)
@Service
public class VetJpaService extends AbstractJpaService<Vet> implements VetService {
    protected VetJpaService(VetRepository vetRepository) {
        super(vetRepository);
    }
}
