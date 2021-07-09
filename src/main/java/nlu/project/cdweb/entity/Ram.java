package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "ram")
public class Ram {
    @Id @Min(1) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idram")
    private String id;

    @NotNull @NotEmpty
    @Column(name = "dungluong")
    private String content;

    @NotNull @NotEmpty @Max(1)
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
