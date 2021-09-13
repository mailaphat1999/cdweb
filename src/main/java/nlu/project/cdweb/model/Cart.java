package nlu.project.cdweb.model;

import lombok.Getter;
import lombok.Setter;
import nlu.project.cdweb.entity.CartDetail;
import nlu.project.cdweb.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {
    @Setter
    private static HashMap<String, CartDetail> details;
    @Setter
    private static int total;

    public Cart() {
        this.details = new HashMap<>();
        this.total = 0;
    }

    public CartDetail get(String id) {
        return details.get(id);
    }

    public static void put(Product product) {
        CartDetail cartDetail;
        if(details.get(product.getId())==null){
            cartDetail = new CartDetail();
            cartDetail.setQuatity(1);
            cartDetail.setPrice(product.getPrice());
            cartDetail.setProduct(product);
            // check date sale
            if(true) {
                cartDetail.setSale(product.getSale().getPercent());
            }else {
                cartDetail.setSale(0);
            }
            cartDetail.updateTotal();
            details.put(product.getId(),cartDetail);
        }else {
            cartDetail = details.get(product.getId());
            cartDetail.setQuatity(cartDetail.getQuatity()+1);
            cartDetail.updateTotal();
        }
    }

    public void put(Product product, int quantity) {
        CartDetail cartDetail;
        if(details.get(product.getId())==null){
            cartDetail = new CartDetail();
            cartDetail.setQuatity(quantity);
            cartDetail.setPrice(product.getPrice());
            // check date sale
            if(true) {
                cartDetail.setSale(product.getSale().getPercent());
            }else {
                cartDetail.setSale(0);
            }
            cartDetail.updateTotal();
            details.put(product.getId(),cartDetail);
        }else {
            cartDetail = details.get(product.getId());
            cartDetail.setQuatity(cartDetail.getQuatity()+quantity);
            cartDetail.updateTotal();
        }
        updateTotal();
    }

    public void remove(String id) {
        details.remove(id);
        updateTotal();
    }

    public int updateTotal(){
        total = 0;
        for(Map.Entry<String, CartDetail> entry : details.entrySet()) {
            String key = entry.getKey();
            CartDetail cartDetail = entry.getValue();
            total += cartDetail.getTotal();
        }
        return total;
    }
    public int size() {
        return details.size();
    }
    public HashMap<String, CartDetail> getDetails() {
        return details;
    }
    public int getTotal(){
        return total;
    }

    public void update(ArrayList<Integer> listQty) {
        Iterator cartIterator = getDetails().entrySet().iterator();
        int index = 0;
        while (cartIterator.hasNext()){
            CartDetail detail = (CartDetail) (((Map.Entry) cartIterator.next()).getValue());
            detail.setQuatity(listQty.get(index));
            detail.updateTotal();
            index++;
        }
        updateTotal();
    }
}
