package nlu.project.cdweb.controller;


import nlu.project.cdweb.entity.Cart;
import nlu.project.cdweb.entity.Product;
import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.service.ProductService;
import nlu.project.cdweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;


@Controller
public class CartController {
    Cart cart;
    @Autowired
    ProductService productService;

    @RequestMapping("cart")
    public String viewCart(HttpSession session,Model model) {
        DuplicateCode.setCartAndUser(session,model);
       return "cart";
    }

    @RequestMapping("cart/add")
    public void addCart(@RequestParam String id, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");

        Product product = productService.findByID(id);

        cart.put(product);
        session.setAttribute("cart", cart);
    }

    @RequestMapping("cart/remove")
    public void removeCart(@RequestParam String id, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");

        Product product = productService.findByID(id);

        cart.remove(id);
        session.setAttribute("cart", cart);
    }

    @RequestMapping("cart/clear")
    public void clearCart(HttpSession session) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }

    @RequestMapping("cart/update")
    public void updateCart(HttpSession session) {
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", cart);
    }


    public static Cart getCart(HttpSession session){
        if (session.getAttribute("cart") == null) {
            Cart cart = new Cart();
            session.setAttribute("cart",cart);
            return cart;
        }
        return (Cart) session.getAttribute("cart");
    }
}