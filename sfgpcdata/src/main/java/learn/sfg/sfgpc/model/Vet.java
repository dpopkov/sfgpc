package learn.sfg.sfgpc.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<VetSpecialty> specialties = new HashSet<>();

    public Vet() {
    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Set<VetSpecialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<VetSpecialty> specialties) {
        this.specialties = specialties;
    }
}
