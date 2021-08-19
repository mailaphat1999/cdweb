package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Proxy(lazy=false)
@Table(name = "donhang")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddonhang")
    private String id;

    @Column(name = "idtinhtrang")
    @NotNull
    private String status;

    @Column(name = "ngaytao")
    @NotNull
    private String dayCreate;

    @Column(name = "diachi")
    @NotNull
    private String address;

    @Column(name = "hinhthuctt")
    private String payMethod;

    @NotNull
    @Column(name = "ten")
    private String nameReceive;

    @NotNull
    @Column(name = "sdt")
    private String phone;

    @Transient
    private int total;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
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
