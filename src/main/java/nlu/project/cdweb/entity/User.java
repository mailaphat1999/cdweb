package nlu.project.cdweb.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "nguoidung")
public class User {
	@Id
	@Column(name = "iduser")
    private String id;
	@Column(name = "taikhoan")
    private String username;
	@Column(name = "matkhau")
    private String password;
	@Column(name = "ten")
    private String name;
	@Column(name = "img")
    private String image;
	@Column(name = "sdt")
    private String phone;
	@Column(name = "diachi")
    private String address;
	@Column(name = "email")
    private String email;
	@Column(name = "gioitinh")
    private String gender;
	@Column(name = "ngaysinh")
    private String dob;
	@Column(name = "ptthanhtoan")
    private String payMethod;
	@Column(name = "quyen")
    private String permission;
	@Column(name = "active")
    private String active;
	@Column(name = "ngaysuacuoi")
    private String lastChange;

    @OneToMany(mappedBy="wishlist")
    private Set<Wishlist> wishLists;
    @OneToMany(mappedBy="order")
    private Set<Order> orders;

    @Override
    public String toString() {
        return String.format("User (id=%s, username=%s, password=%s, name=%s, image=%s, phone=%s, address=%s, email=%s, gender=%s, dob=%s, payMethod=%s, permission=%s, active=%s, lastChange=%s, wishLists=%s, orders=%s)", this.id, this.username, this.password, this.name, this.image, this.phone, this.address, this.email, this.gender, this.dob, this.payMethod, this.permission, this.active, this.lastChange, this.wishLists, this.orders);
    }
}
