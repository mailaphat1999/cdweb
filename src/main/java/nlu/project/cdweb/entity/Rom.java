package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "rom")
public class Rom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrom")
    private String id;
    @Column(name = "dungluong")
    private String content;
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="rom")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format("Rom (id=%s, content=%s, active=%s)", this.id, this.content, this.active);
    }
}
