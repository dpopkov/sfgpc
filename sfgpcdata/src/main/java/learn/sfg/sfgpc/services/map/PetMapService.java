package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Pet;
import learn.sfg.sfgpc.model.PetType;
import learn.sfg.sfgpc.services.PetService;
import learn.sfg.sfgpc.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.IN_MEMORY_HASH_MAP)
@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService {
    private final PetTypeService petTypeService;

    public PetMapService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet save(Pet pet) {
        if (pet != null) {
            final PetType petType = pet.getPetType();
            if (petType == null) {
                throw new IllegalStateException("Pet Type is required");
            }
            if (petType.getId() == null) {
                petTypeService.save(petType);
            }
            return super.save(pet);
        }
        return null;
    }
}
