package learn.sfg.sfgpc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "vet_specialties")
public class VetSpecialty extends BaseEntity {

    private String description;

    public VetSpecialty() {
    }

    public VetSpecialty(String description) {
        this.description = description;
    }
}
