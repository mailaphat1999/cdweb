package nlu.project.cdweb.controller;


import nlu.project.cdweb.custom.MyDateFormat;
import nlu.project.cdweb.entity.*;
import nlu.project.cdweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Controller
public class OrderController {
    Cart cart;
    User user;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String order(HttpSession session, Model model) {
        DuplicateCode.setCartAndUser(session,model);
        return "order";
    }

    @RequestMapping(value = "/order/checkout",method = RequestMethod.POST)
    public String checkout(HttpSession session, HttpServletRequest request) {
        if(session.getAttribute("user") == null){return "order";}
        if(session.getAttribute("cart") == null){return "order";}
        cart = (Cart) session.getAttribute("cart");
        user = (User) session.getAttribute("user");
        if(cart.size()<1){return "order";}

        Order order = setOrder(user,request);
        Set<OrderDetail> details = new HashSet<>();
        for (Map.Entry entry:cart.getDetails().entrySet()) {
            CartDetail cartDetail = (CartDetail) entry.getValue();
            OrderDetail orderDetail = setOrderDetail(cartDetail);
            details.add(orderDetail);
        }
        order.setItems(details);
        orderService.save(order);
        return "success";
    }

    public static Order setOrder(User user,HttpServletRequest request){
        Order order = new Order();
        order.setStatus("1");
        order.setAddress(request.getParameter("address"));
        order.setDayCreate(MyDateFormat.getNow());
        order.setPayMethod("Cash on delivery");
        order.setNameReceive(request.getParameter("name"));
        order.setPhone(request.getParameter("phone"));
        order.setOrder(user);
        return order;
    }

    public static OrderDetail setOrderDetail(CartDetail cartDetail){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setAmount(cartDetail.getQuatity());
        orderDetail.setIdProduct(cartDetail.getProduct().getId());
        orderDetail.setPrice(cartDetail.getPrice()*cartDetail.getQuatity());
        orderDetail.setSale(cartDetail.getSale());
        orderDetail.setTotal(cartDetail.getTotal());
        return orderDetail;
    }


}