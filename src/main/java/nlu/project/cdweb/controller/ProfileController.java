package nlu.project.cdweb.controller;


import nlu.project.cdweb.custom.MyDateFormat;
import nlu.project.cdweb.custom.Security;
import nlu.project.cdweb.entity.Product;
import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.entity.Wishlist;
import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class ProfileController {

	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	WishlistService wishlistService;
	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public ModelAndView profile(HttpSession session, Model model, HttpServletResponse response) throws IOException {
		if (session.getAttribute("user")==null){ response.sendRedirect("home"); }
        ModelAndView mav = new ModelAndView("profile");
		User user = (User) session.getAttribute("user");
		model.addAttribute("user",user);
		DuplicateCode.setCartAndUser(session,mav);
		return mav;
	}

	@RequestMapping(value = "/profile/update",method = RequestMethod.POST)
	public ModelAndView update(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (session.getAttribute("user")==null){ response.sendRedirect("home"); }
		User user = (User) session.getAttribute("user");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String lastChange = MyDateFormat.getNow();
		user.setName(name);user.setEmail(email);user.setPhone(phone);user.setAddress(address);user.setDob(dob);user.setLastChange(lastChange);
		userService.save(user);
		session.setAttribute("user",user);

		String referer = request.getHeader("Referer");
		return new ModelAndView( "redirect:"+referer);
	}

	@RequestMapping(value = "/profile/changePass",method = RequestMethod.POST)
	public ModelAndView changePass(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (session.getAttribute("user")==null){ response.sendRedirect("home"); }
		User user = (User) session.getAttribute("user");

		String username = request.getParameter("username");
		String password = Security.hashMD5(request.getParameter("password"));
		String newpassword = Security.hashMD5(request.getParameter("newpassword"));
		String repassword = Security.hashMD5(request.getParameter("repassword"));
		String lastChange = MyDateFormat.getNow();

		String referer = request.getHeader("Referer");
		if(user.getPassword().equals(password)&&user.getUsername().equals(username)&&newpassword.equals(repassword)){
			user.setPassword(newpassword);
			user.setLastChange(lastChange);
			userService.save(user);
			session.setAttribute("user",null);
			return new ModelAndView( "redirect:"+referer);
		}
		session.setAttribute("user",user);
		return new ModelAndView( "redirect:"+referer);
	}
	@RequestMapping(value = "/account/addWishlist")
	public ModelAndView addWishlist(HttpServletRequest request, HttpSession session) {
		String referer = request.getHeader("Referer");
		String id = request.getParameter("id");
		if (session.getAttribute("user")==null){
			return new ModelAndView( "redirect:"+referer);
		}
		User u = (User) session.getAttribute("user");
		Product p = productService.findByID(id);
		Wishlist wishlist = new Wishlist();
		wishlist.setWishlist(u);
		wishlist.setItem(p);
		wishlistService.save(wishlist);
		u.getWishLists().add(wishlist);
		return new ModelAndView( "redirect:"+referer);
	}
	@RequestMapping(value = "/profile/clearWishlist")
	public ModelAndView clearWishlist(HttpServletRequest request, HttpSession session) {
		String referer = request.getHeader("Referer");
		String id = request.getParameter("id");
		if (session.getAttribute("user")==null){
			return new ModelAndView( "redirect:"+referer);
		}
		User u = (User) session.getAttribute("user");

		u.setWishLists(u.getWishLists().stream().filter(wishlist -> !wishlist.getId().equals(id)).collect(Collectors.toSet()));

		wishlistService.deleteOne(id);
		session.setAttribute("user",u);
		return new ModelAndView( "redirect:"+referer);
	}
	@RequestMapping(value = "/profile/clearAllWishlist")
	public ModelAndView clearAllWishlist(HttpServletRequest request, HttpSession session) {
		String referer = request.getHeader("Referer");
		if (session.getAttribute("user")==null){
			return new ModelAndView( "redirect:"+referer);
		}
		User u = (User) session.getAttribute("user");

		wishlistService.deleteAll(u);
		u.setWishLists(new HashSet<Wishlist>());
		session.setAttribute("user",u);

		return new ModelAndView( "redirect:"+referer);
	}
	@RequestMapping(value = "/profile/cancelOrder")
	public ModelAndView cancelOrder(HttpServletRequest request, HttpSession session) {
		String referer = request.getHeader("Referer");
		String id = request.getParameter("id");
		if (session.getAttribute("user")==null){
			return new ModelAndView( "redirect:"+referer);
		}
		User u = (User) session.getAttribute("user");

		orderService.cancelOrder(id);

		u.setOrders(u.getOrders().stream().filter(order -> {
			if(order.getId().equals(id)&&order.getStatus().equals("1"))
				order.setStatus("4");
				return true;
		}
		).collect(Collectors.toSet()));

		session.setAttribute("user",u);
		return new ModelAndView( "redirect:"+referer);
	}
	
}