package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "forgotpass")
public class ForgetPass {
    @Id
    @Column(name = "idforgot")
    private String id;
    @Column(name = "ngaytao")
    private String dayCreate;
    @Column(name = "email")
    private String email;

}
