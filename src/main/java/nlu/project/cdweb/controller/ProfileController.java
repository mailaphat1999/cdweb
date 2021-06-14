package nlu.project.cdweb.controller;


import nlu.project.cdweb.custom.MyDateFormat;
import nlu.project.cdweb.custom.Security;
import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ProfileController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String listProducts(HttpSession session, Model model, HttpServletResponse response) throws IOException {
		if (session.getAttribute("user")==null){ response.sendRedirect("home"); }
		User user = (User) session.getAttribute("user");
		model.addAttribute("user",user);
		return "profile";
	}

	@RequestMapping(value = "/profile/update",method = RequestMethod.POST)
	public void update(HttpSession session, Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (session.getAttribute("user")==null){ response.sendRedirect("home"); }
		User user = (User) session.getAttribute("user");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String lastChange = MyDateFormat.getNow();
		user.setName(name);user.setEmail(email);user.setPhone(phone);user.setAddress(address);user.setGender(gender);user.setDob(dob);user.setLastChange(lastChange);
		userService.save(user);
		session.setAttribute("user",user);
		model.addAttribute("user",user);
		response.sendRedirect("profile");
	}

	@RequestMapping(value = "/profile/updatepass",method = RequestMethod.POST)
	public void updatePassword(HttpSession session, Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (session.getAttribute("user")==null){ response.sendRedirect("home"); }
		User user = (User) session.getAttribute("user");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String repassword = request.getParameter("repassword");
		String lastChange = MyDateFormat.getNow();

		if(user.getUsername().equals(username)&&newpassword.equals(repassword)&&user.getPassword().equals(Security.hashMD5(password))){
			user.setPassword(Security.hashMD5(password));user.setLastChange(lastChange);
			userService.save(user);
		}
		response.sendRedirect("logout?locate=home");
	}
	
}