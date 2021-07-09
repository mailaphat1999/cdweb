package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "gia")
public class Price {
    @Id @Min(1) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtgia")
    private String id;

    @NotNull
    @Column(name = "start")
    private int start;

    @NotNull
    @Column(name = "end")
    private int end;

    @NotNull @NotEmpty
    @Max(1)
    @Column(name = "active")
    private String active;

    @Transient  
    private List<Product> items;

    @Override
    public String toString() {
        return String.format("Price (id=%s, start=%s, end=%s, active=%s)", this.id, this.start, this.end, this.active);
    }
}
