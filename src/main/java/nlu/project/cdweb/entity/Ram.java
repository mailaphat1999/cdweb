package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "ram")
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idram")
    private String id;
    @Column(name = "dungluong")
    private String content;
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="ram")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format(
                "Ram (id=%s, content=%s, active=%s)", this.id, this.content, this.active);
    }
}
