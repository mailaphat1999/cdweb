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
@Table(name = "hang")
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhang")
    @Min(1) @NotNull
    private String id;

    @NotNull @NotEmpty
    @Column(name = "tenhang")
    private String name;

    @NotNull @Min(10)
    @Column(name = "logohang")
    private String image;

    @NotNull @NotEmpty @Max(1)
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="brand")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format("Brand (id=%s, name=%s, image=%s, active=%s)", this.id, this.name, this.image, this.active);
    }
}
