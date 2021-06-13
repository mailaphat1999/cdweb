package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "chitietdonhang")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchitiet")
    private String id;
    @Column(name = "idsp")
    private String idProduct;
    @Column(name = "soluong")
    private int amount;
    @Column(name = "tamtinh")
    private int price;
    @Column(name = "giamgia")
    private int sale;
    @Column(name = "tongcong")
    private int total;

    @ManyToOne
    @JoinColumn(name="iddonhang", nullable=false)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "idsp",
            referencedColumnName = "idsp",
            updatable = false,
            insertable = false
    )
    private Product item;

    public void updateTotal(){
        this.total = this.amount * (price-sale);
    }

    @Override
    public String toString() {
        return String.format("OrderDetail (id=%s, idOrder=%s, idProduct=%s, amount=%s, price=%s, sale=%s, total=%s)", this.id, this.order.getId(), this.idProduct, this.amount, this.price, this.sale, this.total);
    }
}
