package nlu.project.cdweb.model;

import lombok.Getter;
import lombok.Setter;
import nlu.project.cdweb.custom.Config;
import nlu.project.cdweb.entity.Product;

import java.util.HashMap;

@Getter @Setter
public class Compare {
    private static HashMap<String, Product> data;

    public Compare() {
        this.data = new HashMap<>(Config.COMPAREITEMS);
    }
    public Product get(String id) {
        return data.get(id);
    }

    public static void put(Product product) {
        data.put(product.getId(), product);
    }

    public void remove(String id) {
        data.remove(id);
    }

}
