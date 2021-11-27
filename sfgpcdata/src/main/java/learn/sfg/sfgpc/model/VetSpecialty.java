package learn.sfg.sfgpc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vet_specialties")
public class VetSpecialty extends BaseEntity {

    private String description;

    public VetSpecialty() {
    }

    public VetSpecialty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
