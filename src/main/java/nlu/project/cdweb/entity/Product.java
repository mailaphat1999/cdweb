package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor

@Entity
@Proxy(lazy=false)
@Table(name = "sanpham")
public class Product implements Serializable {
    @Id @NaturalId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsp")
    private String id;
    @Column(name = "img")
    private String image;
    @Column(name = "ten")
    private String name;
    @Column(name = "gia")
    private int price;
    @Column(name = "soluong")
    private int storage;
    @Column(name = "baohanh")
    private int guarantee ;
    @Column(name = "img01")
    private String image1;
    @Column(name = "img02")
    private String image2;
    @Column(name = "img03")
    private String image3;
    @Column(name = "img04")
    private String image4;
    @Column(name = "kichthuoc")
    private String screen;
    @Column(name = "cameratruoc")
    private String frontCam;
    @Column(name = "camerasau")
    private String rearCam;
    @Column(name = "active")
    private String active;
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
