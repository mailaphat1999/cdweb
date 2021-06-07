package nlu.project.cdweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Getter @Setter

public class Cart {
    private static HashMap<String, CartDetail> data;
    private static int total;

    public Cart() {
        this.data = new HashMap<>();
        this.total = 0;
    }

    public CartDetail get(String id) {
        return data.get(id);
    }

    public static void put(Product product) {
        CartDetail cartDetail;
        if(data.get(product.getId())==null){
            cartDetail = new CartDetail();
            cartDetail.setQuanlity(1);
            cartDetail.setPrice(product.getPrice());
            // check date sale
            if(true) {
                cartDetail.setSale(product.getSale().getPercent());
            }else {
                cartDetail.setSale(0);
            }
            cartDetail.updateTotal();
            data.put(product.getId(),cartDetail);
        }else {
            cartDetail = data.get(product.getId());
            cartDetail.setQuanlity(cartDetail.getQuanlity()+1);
            cartDetail.updateTotal();
        }
    }

    public void put(Product product, int quanlity) {
        CartDetail cartDetail;
        if(data.get(product.getId())==null){
            cartDetail = new CartDetail();
            cartDetail.setQuanlity(quanlity);
            cartDetail.setPrice(product.getPrice());
            // check date sale
            if(true) {
                cartDetail.setSale(product.getSale().getPercent());
            }else {
                cartDetail.setSale(0);
            }
            cartDetail.updateTotal();
            data.put(product.getId(),cartDetail);
        }else {
            cartDetail = data.get(product.getId());
            cartDetail.setQuanlity(cartDetail.getQuanlity()+quanlity);
            cartDetail.updateTotal();
        }
    }

    public void remove(String id) {
        data.remove(id);
    }

    public int updateTotal(){
        for(Map.Entry<String, CartDetail> entry : data.entrySet()) {
            String key = entry.getKey();
            CartDetail cartDetail = entry.getValue();
            total += cartDetail.getTotal();
        }
        return total;
    }


}
