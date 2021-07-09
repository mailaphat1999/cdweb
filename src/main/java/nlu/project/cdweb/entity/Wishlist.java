package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor

@Entity
@Proxy(lazy=false)
@Table(name = "yeuthich")

public class Wishlist {
    @Id @Min(1) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlove")
    private String id;

    @ManyToOne
    @JoinColumn(name="iduser", nullable=false)
    private User wishlist;

    @OneToOne
    @JoinColumn(name = "idsp", referencedColumnName = "idsp")
    private Product item;

    @Override
    public String toString() {
        return String.format("Wishlist (id=%s)", this.id);
    }
}
