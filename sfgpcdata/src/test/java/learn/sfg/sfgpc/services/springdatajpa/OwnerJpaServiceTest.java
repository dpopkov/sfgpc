package learn.sfg.sfgpc.services.springdatajpa;

import learn.sfg.sfgpc.model.Owner;
import learn.sfg.sfgpc.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
    private static final String LAST_NAME = "Doe";

    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        given(ownerRepository.findByLastName(anyString())).willReturn(Optional.of(returnOwner));

        Owner doe = service.findByLastName(LAST_NAME).orElseThrow();

        then(ownerRepository).should().findByLastName(LAST_NAME);
        assertThat(doe.getLastName()).isEqualTo(LAST_NAME);
    }

    @Test
    void testFindAll() {
        Owner returnOwner2 = Owner.builder().id(2L).build();
        given(ownerRepository.findAll()).willReturn(List.of(returnOwner, returnOwner2));

        final Set<Owner> all = service.findAll();

        then(ownerRepository).should().findAll();
        assertThat(all).hasSize(2);
        assertThat(all).contains(returnOwner);
        assertThat(all).contains(returnOwner2);
    }

    @Test
    void testFindById() {
        given(ownerRepository.findById(anyLong())).willReturn(Optional.of(returnOwner));

        final Optional<Owner> byId = service.findById(1L);

        then(ownerRepository).should().findById(anyLong());
        assertThat(byId).contains(returnOwner);
    }

    @Test
    void testFindByIdNotFound() {
        given(ownerRepository.findById(anyLong())).willReturn(Optional.empty());

        final Optional<Owner> byId = service.findById(1L);

        then(ownerRepository).should().findById(anyLong());
        assertThat(byId).isEmpty();
    }

    @Test
    void testSave() {
        Owner owner = Owner.builder().lastName("Doe").build();
        given(ownerRepository.save(any())).willReturn(returnOwner);

        Owner saved = service.save(owner);

        then(ownerRepository).should().save(any());
        assertNotNull(saved);
    }

    @Test
    void testDelete() {
        service.delete(returnOwner);
        then(ownerRepository).should().delete(any());
    }

    @Test
    void testDeleteById() {
        service.deleteById(1L);
        then(ownerRepository).should().deleteById(anyLong());
    }
}
