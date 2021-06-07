package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;

 @NoArgsConstructor

public class CartDetail {
     @Getter @Setter
    private int quatity;
     @Getter @Setter
    private int price;
     @Getter @Setter
    private int sale;
     @Getter @Setter
    private int total;
     @Getter @Setter
    private Product product;

    public void updateTotal(){
        this.total = this.price*this.quatity;
    }
}
