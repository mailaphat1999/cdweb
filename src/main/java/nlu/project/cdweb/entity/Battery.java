package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "pin")
public class Battery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpin")
    @Min(1) @NotNull
    private String id;

    @NotNull @NotEmpty
    @Column(name = "dungluong")
    private String content;

    @NotNull @NotEmpty @Max(1)
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="battery")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format("Battery (id=%s, content=%s, active=%s)", this.id, this.content, this.active);
    }
}
