package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.PetType;
import learn.sfg.sfgpc.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.IN_MEMORY_HASH_MAP)
@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {
}
