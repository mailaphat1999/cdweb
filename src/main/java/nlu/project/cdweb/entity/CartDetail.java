package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor

public class CartDetail {

    private int quanlity;
    private int price;
    private int sale;
    private int total;

    public void updateTotal(){
        this.total = this.price*this.quanlity;
    }
}
