package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.VetSpecialty;
import learn.sfg.sfgpc.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.IN_MEMORY_HASH_MAP)
@Service
public class VetSpecialtyMapService extends AbstractMapService<VetSpecialty> implements VetSpecialtyService {
}
