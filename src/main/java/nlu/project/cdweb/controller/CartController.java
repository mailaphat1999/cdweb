package nlu.project.cdweb.controller;


import nlu.project.cdweb.model.Cart;
import nlu.project.cdweb.entity.Product;
import nlu.project.cdweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


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
    public ModelAndView addCart(@RequestParam String id, HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");

        Product product = productService.findByID(id);
        cart.put(product);
        session.setAttribute("cart", cart);

        String referer = request.getHeader("Referer");
        return new ModelAndView( "redirect:"+referer);
    }

    @RequestMapping("cart/remove")
    public ModelAndView removeCart(@RequestParam String id, HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        } else cart = (Cart) session.getAttribute("cart");

        Product product = productService.findByID(id);

        cart.remove(id);
        session.setAttribute("cart", cart);

        String referer = request.getHeader("Referer");
        return new ModelAndView( "redirect:"+referer);
    }

    @RequestMapping(value = "cart/update",method = RequestMethod.POST)
    public void updateCart(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            response.getWriter().println(true);
        } else {
            cart = (Cart) session.getAttribute("cart");

            String[] myJsonData = request.getParameterValues("json[]");
            ArrayList<Integer> listQty = new ArrayList<>();
            for (int i = 0; i < myJsonData.length; i++) {
                listQty.add(Integer.parseInt(myJsonData[i]));
            }
            cart.update(listQty);
            session.setAttribute("cart", cart);
            response.getWriter().println(false);
        }
        return;
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