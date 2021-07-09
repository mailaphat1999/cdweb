package nlu.project.cdweb.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import java.util.Set;


@Getter @Setter @NoArgsConstructor

@Entity
@Proxy(lazy=false)
@Table(name = "nguoidung")
public class User {
    @Id @Min(1) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
    private String id;

    @Min(6) @NotNull
	@Column(name = "taikhoan")
    private String username;
    @Min(6) @NotNull
	@Column(name = "matkhau")
    private String password;

	@Column(name = "ten")
    private String name;

	@Column(name = "img")
    private String image;

    @Min(10)
	@Column(name = "sdt")
    private String phone;
    @NotNull
	@Column(name = "diachi")
    private String address;
    @Email
	@Column(name = "email")
    private String email;

    @NotNull
	@Column(name = "gioitinh")
    private String gender;


	@Column(name = "ngaysinh")
    private String dob;

	@Column(name = "ptthanhtoan")
    private String payMethod;

    @NotNull @NotEmpty @Max(1)
	@Column(name = "quyen")
    private String permission;
    @NotNull @NotEmpty @Max(1)
	@Column(name = "active")
    private String active;

    @NotNull @Min(10)
	@Column(name = "ngaysuacuoi")
    private String lastChange;
    @NotNull @Min(10)
	@Column(name = "ngaytao")
    private String dateCreate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "wishlist",  orphanRemoval = true)
    private Set<Wishlist> wishLists;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order",  orphanRemoval = true)
    private Set<Order> orders;

    @Transient
    private int totalBuy = 0;

    public void updateTotalBuy(){
        for (Order order: orders) {
            if(order.getStatus().equals("3")) {
                for (OrderDetail orderDetail : order.getItems()) {
                    this.totalBuy+= orderDetail.getAmount();
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("User (id=%s, username=%s, password=%s, name=%s, image=%s, phone=%s, address=%s, email=%s, gender=%s, dob=%s, payMethod=%s, permission=%s, active=%s, lastChange=%s)", this.id, this.username, this.password, this.name, this.image, this.phone, this.address, this.email, this.gender, this.dob, this.payMethod, this.permission, this.active, this.lastChange);
    }
}
