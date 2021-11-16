package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {
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
