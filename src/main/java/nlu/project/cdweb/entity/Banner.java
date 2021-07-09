package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "slide")
public class Banner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idslide")
    @Min(1) @NotNull
    private String id;

    @NotNull
    @Column(name = "srcslide")
    private String image;

    @NotNull @NotEmpty @Max(1)
    @Column(name = "active")
    private String active;

    @NotNull @NotEmpty @Min(3)
    @Column(name = "location")
    private String location;

    @Override
    public String toString() {
        return String.format("Banner (id=%s, image=%s, location=%s, active=%s)", this.id, this.image, this.location, this.active);
    }
}
