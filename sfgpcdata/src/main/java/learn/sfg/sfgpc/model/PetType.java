package learn.sfg.sfgpc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }
}
