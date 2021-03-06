package learn.sfg.sfgpc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vets_vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "vet_specialty_id"))
    private Set<VetSpecialty> specialties = new HashSet<>();

    public Vet() {
    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
