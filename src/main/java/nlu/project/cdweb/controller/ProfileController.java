package nlu.project.cdweb.controller;


import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.repository.UserRepository;
import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
public class ProfileController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String listProducts(HttpServletRequest request,Model model) {
		Optional<User> resultUser = userService.findByID("1");
		User user = resultUser.get();
		user.updateTotalBuy();
		model.addAttribute("user",user);
		return "profile";
	}

	
}