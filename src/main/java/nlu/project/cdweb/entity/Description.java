package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "mota")
public class Description {
    @Id
    @Column(name = "idsp")
    @Min(1) @NotNull
    private String id;

    @NotNull
    @Column(name = "tieude1")
    private String title1;

    @NotNull
    @Column(name = "tieude2")
    private String title2;

    @NotNull
    @Column(name = "tieude3")
    private String title3;

    @NotNull @Min(10)
    @Column(name = "anh1")
    private String image1;

    @NotNull @Min(10)
    @Column(name = "anh2")
    private String image2;

    @NotNull @Min(10)
    @Column(name = "anh3")
    private String image3;

    @NotNull
    @Column(name = "chitiet1")
    private String detail1;

    @NotNull
    @Column(name = "chitiet2")
    private String detail2;

    @NotNull
    @Column(name = "chitiet3")
    private String detail3;

    @OneToOne(mappedBy = "description")
    private Product product;

    @Override
    public String toString() {
        return String.format("Description (title1=%s, title2=%s, title3=%s, image1=%s, image2=%s, image3=%s, detail1=%s, detail2=%s, detail3=%s)", this.title1, this.title2, this.title3, this.image1, this.image2, this.image3, this.detail1, this.detail2, this.detail3);
    }
}
