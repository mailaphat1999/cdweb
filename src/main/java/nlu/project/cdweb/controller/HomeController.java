package nlu.project.cdweb.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	@Autowired
	BannerService bannerService;
	@Autowired
	BatteryService batteryService;
	@Autowired
	BrandService brandService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;
	@Autowired
	RamService ramService;
	@Autowired
	RomService romService;
	@Autowired
	SaleService saleService;
	@Autowired
	UserService userService;
	@Autowired
	PriceService priceService;
	
	@RequestMapping({"/", "home"})
	public String home(HttpSession session,Model model) {
        model.addAttribute("brands",brandService.list());
        model.addAttribute("hotProduct",productService.hotProducts());
        model.addAttribute("newProduct",productService.newProducts());
        model.addAttribute("saleProduct",productService.saleProducts());
        model.addAttribute("otherProduct",productService.otherProducts());
        model.addAttribute("carousel",bannerService.carousel());
        model.addAttribute("bottom",bannerService.bottom());
        model.addAttribute("foot",bannerService.foot());
        model.addAttribute("countProduct",productService.count());
        model.addAttribute("countUser",userService.count());
        model.addAttribute("countSale",saleService.count());
        DuplicateCode.setCartAndUser(session,model);
		return "home";
	}
}