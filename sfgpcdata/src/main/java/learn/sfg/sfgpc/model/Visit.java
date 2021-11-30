package learn.sfg.sfgpc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    @ManyToOne
    private Pet pet;

    public Visit() {
    }

    public Visit(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }
}
