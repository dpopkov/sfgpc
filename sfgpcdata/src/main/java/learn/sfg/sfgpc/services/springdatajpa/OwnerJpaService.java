package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.repositories.OwnerRepository;
import learn.sfg.sfgpc.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Profile(Profiles.SPRING_DATA_JPA)
@Service
public class OwnerJpaService extends AbstractJpaService<Owner> implements OwnerService {

    public OwnerJpaService(OwnerRepository ownerRepository) {
        super(ownerRepository);
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return ((OwnerRepository) crudRepository).findByLastName(lastName);
    }
}
