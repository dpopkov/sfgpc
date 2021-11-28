package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Vet;
import learn.sfg.sfgpc.model.VetSpecialty;
import learn.sfg.sfgpc.services.VetService;
import learn.sfg.sfgpc.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile(Profiles.IN_MEMORY_HASH_MAP)
@Service
public class VetMapService extends AbstractMapService<Vet> implements VetService {
    private final VetSpecialtyService vetSpecialtyService;

    public VetMapService(VetSpecialtyService vetSpecialtyService) {
        this.vetSpecialtyService = vetSpecialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            final Set<VetSpecialty> specialties = vet.getSpecialties();
            if (specialties.size() != 0) {
                specialties.forEach(vs -> {
                    if (vs.getId() == null) {
                        vetSpecialtyService.save(vs);
                    }
                });
            }
            return super.save(vet);
        }
        return null;
    }
}
