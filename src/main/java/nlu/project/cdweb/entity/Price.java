package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "gia")
public class Price {
    @Id
    @Column(name = "idtgia")
    private String id;
    @Column(name = "start")
    private int start;
    @Column(name = "end")
    private int end;
    @Column(name = "active")
    private String active;

    @Override
    public String toString() {
        return String.format("Price (id=%s, start=%s, end=%s, active=%s)", this.id, this.start, this.end, this.active);
    }
}
