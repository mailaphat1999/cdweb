package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor

@Entity
@Proxy(lazy=false)
@Table(name = "sanpham")
public class Product implements Serializable {
    @Id @NaturalId @Min(1) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsp")
    private String id;

    @NotNull @Min(10)
    @Column(name = "img")
    private String image;

    @NotNull @Min(4)
    @Column(name = "ten")
    private String name;

    @NotNull
    @Column(name = "gia")
    private int price;

    @NotNull @Size(min = 0)
    @Column(name = "soluong")
    private int storage;

    @NotNull @Size(min = 0)
    @Column(name = "baohanh")
    private int guarantee ;

    @NotNull @Min(10)
    @Column(name = "img01")
    private String image1;
    @NotNull @Min(10)
    @Column(name = "img02")
    private String image2;
    @NotNull @Min(10)
    @Column(name = "img03")
    private String image3;
    @NotNull @Min(10)
    @Column(name = "img04")
    private String image4;

    @NotNull @Min(3)
    @Column(name = "kichthuoc")
    private String screen;
    @NotNull @Min(3)
    @Column(name = "cameratruoc")
    private String frontCam;
    @NotNull @Min(3)
    @Column(name = "camerasau")
    private String rearCam;

    @NotNull @NotEmpty @Max(1)
    @Column(name = "active")
    private String active;

    @NotNull @NotEmpty @Max(1)
    @Column(name = "tinhtrang")
    private String status;

    @OneToOne
    @JoinColumn(name = "idsp")
    private Description description;

    @ManyToOne
    @JoinColumn(name="idhang", nullable=false)
    private Brand brand;
    @ManyToOne
    @JoinColumn(name="idram", nullable=false)
    private Ram ram;
    @ManyToOne
    @JoinColumn(name="idrom", nullable=false)
    private Rom rom;
    @ManyToOne
    @JoinColumn(name="idpin", nullable=false)
    private Battery battery;
    @ManyToOne
    @JoinColumn(name="idkm", nullable=false)
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "idsp",referencedColumnName ="idsp")
    private Wishlist wishlist;
    @OneToOne
    @JoinColumn(name = "idsp",referencedColumnName ="idsp")
    private OrderDetail orderDetail;

    public String getPriceFormat(){
        return String.format("%,d", this.price) +"đ";
    }

    @Override
    public String toString() {
//        return String.format("Product (id=%s, image=%s, name=%s, price=%s, storage=%s, guarantee=%s, image1=%s, image2=%s, image3=%s, image4=%s, screen=%s, frontCam=%s, rearCam=%s, active=%s, status=%s, description=%s, brand=%s, ram=%s, rom=%s, battery=%s, sale=%s)", this.id, this.image, this.name, this.price, this.storage, this.guarantee, this.image1, this.image2, this.image3, this.image4, this.screen, this.frontCam, this.rearCam, this.active, this.status, this.description, this.brand, this.ram, this.rom, this.battery, this.sale);
        return String.format("Product (id=%s, image=%s, name=%s, price=%s, storage=%s, guarantee=%s, image1=%s, image2=%s, image3=%s, image4=%s, screen=%s, frontCam=%s, rearCam=%s, active=%s, status=%s, brand=%s, ram=%s, rom=%s, battery=%s, sale=%s)", this.id, this.image, this.name, this.price, this.storage, this.guarantee, this.image1, this.image2, this.image3, this.image4, this.screen, this.frontCam, this.rearCam, this.active, this.status, this.brand, this.ram, this.rom, this.battery, this.sale);
    }


}
