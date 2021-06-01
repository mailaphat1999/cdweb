package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "donhang")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iddonhang")
    private String id;
    @Column(name = "idtinhtrang")
    private String status;
    @Column(name = "ngaytao")
    private String dayCreate;
    @Column(name = "diachi")
    private String address;
    @Column(name = "hinhthuctt")
    private String payMethod;
    @Column(name = "ten")
    private String nameReceive;
    @Column(name = "sdt")
    private String phone;

    @Transient
    private int total;

    @OneToMany(mappedBy="order")
    private Set<OrderDetail> items;

    @ManyToOne
    @JoinColumn(name="iduser", nullable=false)
    private User order;

    public void updateTotal(){
        for (OrderDetail detail: this.items) {
            this.total+=detail.getTotal();
        }
    }

    @Override
    public String toString() {
        return String.format("Order (id=%s, status=%s, dayCreate=%s, address=%s, payMethod=%s, nameReceive=%s, phone=%s, total=%s, items=%s)", this.id, this.status, this.dayCreate, this.address, this.payMethod, this.nameReceive, this.phone, this.total, this.items);
    }
}
