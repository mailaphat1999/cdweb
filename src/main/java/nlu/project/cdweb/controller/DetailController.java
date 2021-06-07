package nlu.project.cdweb.controller;


import nlu.project.cdweb.entity.Cart;
import nlu.project.cdweb.entity.Product;
import nlu.project.cdweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class DetailController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product/detail",method = RequestMethod.GET)
    public String detail(@RequestParam String id, Model model) {
        model.addAttribute("product",productService.findByID(id));
        List<Product> relatedProduct = new ArrayList<Product>();
        relatedProduct.addAll(productService.findByID(id).getBrand().getItems());
        model.addAttribute("related",relatedProduct);
        return "detail";
    }

}