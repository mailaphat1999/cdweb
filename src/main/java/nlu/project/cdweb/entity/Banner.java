package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "slide")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idslide")
    private String id;
    @Column(name = "srcslide")
    private String image;
    @Column(name = "active")
    private String active;
    @Column(name = "location")
    private String location;

    @Override
    public String toString() {
        return String.format("Banner (id=%s, image=%s, location=%s, active=%s)", this.id, this.image, this.location, this.active);
    }
}
