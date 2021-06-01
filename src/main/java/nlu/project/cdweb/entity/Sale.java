package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "khuyenmai")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkm")
    private String id;
    @Column(name = "sale")
    private int percent;
    @Column(name = "ngaybdkm")
    private String start;
    @Column(name = "ngayktkm")
    private String end;
    @Column(name = "active")
    private String active;

    @OneToMany(mappedBy="sale")
    private Set<Product> items;

    @Override
    public String toString() {
        return String.format("Sale (id=%s, percent=%s, start=%s, end=%s, active=%s)", this.id, this.percent, this.start, this.end, this.active);
    }
}
