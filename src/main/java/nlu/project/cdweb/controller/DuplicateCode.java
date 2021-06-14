package nlu.project.cdweb.controller;

import nlu.project.cdweb.entity.Cart;
import nlu.project.cdweb.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class DuplicateCode {
    static User user;
    static Cart cart;

    public static void setCartAndUser(HttpSession session, Model model){
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");
        model.addAttribute("cart",cart);

        if (session.getAttribute("user") == null) {
            model.addAttribute("user",null);
        } else {
            user = (User) session.getAttribute("user");
            model.addAttribute("user",user);
        }
    }
}
