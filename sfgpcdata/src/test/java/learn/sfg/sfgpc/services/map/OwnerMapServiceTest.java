package learn.sfg.sfgpc.services.map;

import learn.sfg.sfgpc.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    private final OwnerMapService service = new OwnerMapService();
    private Long id1;
    private Long id2;

    @BeforeEach
    void populateData() {
        Owner o1 = new Owner();
        o1.setFirstName("fn1");
        o1.setLastName("ln1");
        service.save(o1);
        id1 = o1.getId();
        Owner o2 = new Owner();
        o2.setFirstName("fn2");
        o2.setLastName("ln2");
        service.save(o2);
        id2 = o2.getId();
    }

    @Test
    void testFindByLastName() {
        Owner r1 = service.findByLastName("ln1").orElseThrow();
        assertEquals("fn1", r1.getFirstName());
        Owner r2 = service.findByLastName("ln2").orElseThrow();
        assertEquals("fn2", r2.getFirstName());
    }

    @Test
    void testDelete() {
        assertTrue(service.getMap().containsKey(id1));
        service.deleteById(id1);
        assertFalse(service.getMap().containsKey(id1));

        assertTrue(service.getMap().containsKey(id2));
        Owner o2 = service.getMap().get(id2);
        service.delete(o2);
        assertFalse(service.getMap().containsKey(id2));
    }

    @Test
    void testFindById() {
        Owner o1 = service.findById(id1).orElseThrow();
        assertEquals("fn1", o1.getFirstName());
    }

    @Test
    void testFindAll() {
        Set<Owner> all = service.findAll();
        assertEquals(2, all.size());
    }
}
