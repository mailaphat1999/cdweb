package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "yeuthich")
public class Wishlist {
    @Id
    @Column(name = "idlove")
    private String id;
    @Column(name = "idsp")
    private String idProduct;

    @ManyToOne
    @JoinColumn(name="iduser", nullable=false)
    private User wishlist;

    @Override
    public String toString() {
        return String.format("Wishlist (id=%s, idProduct=%s)", this.id, this.idProduct);
    }
}
