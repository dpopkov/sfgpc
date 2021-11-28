package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.model.Pet;
import learn.sfg.sfgpc.services.OwnerService;
import learn.sfg.sfgpc.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Profile(Profiles.IN_MEMORY_HASH_MAP)
@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {
    private final PetService petService;

    public OwnerMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            final Set<Pet> pets = owner.getPets();
            if (pets != null && pets.size() != 0) {
                pets.forEach(p -> {
                    if (p.getId() == null) {
                        petService.save(p);
                    }
                });
            }
            return super.save(owner);
        }
        return null;
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        for (Owner owner : map.values()) {
            if (owner.getLastName().equals(lastName)) {
                return Optional.of(owner);
            }
        }
        return Optional.empty();
    }
}
