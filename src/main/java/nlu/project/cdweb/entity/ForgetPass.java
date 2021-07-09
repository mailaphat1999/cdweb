package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "forgotpass")
public class ForgetPass {
    @Id
    @Column(name = "idforgot")
    @Min(7) @NotNull
    private String id;
    @Column(name = "ngaytao")
    @NotNull
    private String dayCreate;
    @NotNull @Email
    @Column(name = "email")
    private String email;

}
