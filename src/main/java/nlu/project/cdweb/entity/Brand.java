package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "hang")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhang")
    private String id;
    @Column(name = "tenhang")
    private String name;
    @Column(name = "logohang")
    private String image;
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="brand")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format("Brand (id=%s, name=%s, image=%s, active=%s)", this.id, this.name, this.image, this.active);
    }
}
