package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.model.PetType;
import learn.sfg.sfgpc.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {
}
