package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "pin")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpin")
    private String id;
    @Column(name = "dungluong")
    private String content;
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="battery")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format("Battery (id=%s, content=%s, active=%s)", this.id, this.content, this.active);
    }
}
