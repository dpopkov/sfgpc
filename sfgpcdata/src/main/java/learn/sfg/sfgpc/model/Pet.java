package learn.sfg.sfgpc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

    public Pet() {
    }

    public Pet(String name, PetType petType, LocalDate birthDate) {
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
    }

    public void addVisit(Visit visit) {
        this.visits.add(visit);
        visit.setPet(this);
    }
}
