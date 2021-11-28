package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.Profiles;
import learn.sfg.sfgpc.model.Visit;
import learn.sfg.sfgpc.repositories.VisitRepository;
import learn.sfg.sfgpc.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.SPRING_DATA_JPA)
@Service
public class VisitJpaService extends AbstractJpaService<Visit> implements VisitService {
    protected VisitJpaService(VisitRepository visitRepository) {
        super(visitRepository);
    }
}
