package learn.sfg.sfgpc.services;

import learn.sfg.sfgpc.model.Owner;

import java.util.Optional;

public interface OwnerService extends BaseService<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);
}
