package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.model.Pet;
import learn.sfg.sfgpc.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService {
}
