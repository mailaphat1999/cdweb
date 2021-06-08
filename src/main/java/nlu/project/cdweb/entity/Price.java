package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "gia")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtgia")
    private String id;
    @Column(name = "start")
    private int start;
    @Column(name = "end")
    private int end;
    @Column(name = "active")
    private String active;

    @Transient  
    private List<Product> items;

    @Override
    public String toString() {
        return String.format("Price (id=%s, start=%s, end=%s, active=%s)", this.id, this.start, this.end, this.active);
    }
}
