package nlu.project.cdweb.controller;

import javax.servlet.http.HttpSession;

import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	@Autowired
	BrandService brandService;
	@Autowired
	ProductService productService;
	@Autowired
	BannerService bannerService;
	@Autowired
	SaleService saleService;
	@Autowired
	UserService userService;

	@RequestMapping({"/", "home"})
	public ModelAndView home(HttpSession session,Model model) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("brands",brandService.list());
		mav.addObject("hotProduct",productService.hotProducts());
		mav.addObject("newProduct",productService.newProducts());
		mav.addObject("saleProduct",productService.saleProducts());
		mav.addObject("otherProduct",productService.otherProducts());
		mav.addObject("carousel",bannerService.carousel());
		mav.addObject("bottom",bannerService.bottom());
		mav.addObject("foot",bannerService.foot());
		mav.addObject("countProduct",productService.count());
		mav.addObject("countUser",userService.count());
		mav.addObject("countSale",saleService.count());
        DuplicateCode.setCartAndUser(session,mav);
		return mav;
	}
}