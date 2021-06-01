package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Comment {
    private String id;
    private String idProduct;
    private String idUser;
//    private int star;
    private String content;
    private String active;

}
