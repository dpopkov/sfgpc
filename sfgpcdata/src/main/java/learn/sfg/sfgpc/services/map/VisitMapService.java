package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.model.Visit;
import learn.sfg.sfgpc.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new IllegalStateException("Invalid Visit - it has empty or not saved associations");
        }
        return super.save(visit);
    }
}
