package nlu.project.cdweb.controller;

import lombok.Getter;
import lombok.Setter;
import nlu.project.cdweb.entity.Cart;
import nlu.project.cdweb.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Getter @Setter
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
    public static void setCartAndUser(HttpSession session, ModelAndView mav){
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");
        mav.addObject("cart",cart);

        if (session.getAttribute("user") == null) {
            mav.addObject("user",null);
        } else {
            user = (User) session.getAttribute("user");
            mav.addObject("user",user);
        }
    }
}
