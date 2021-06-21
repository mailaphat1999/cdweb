package nlu.project.cdweb.controller;


import nlu.project.cdweb.custom.MyDateFormat;
import nlu.project.cdweb.entity.User;
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


@Controller
public class ProfileController {

	@Autowired
	UserService userService;

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
	public void update(HttpSession session, Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
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
		model.addAttribute("user",user);
		response.sendRedirect("profile");
	}

	
}