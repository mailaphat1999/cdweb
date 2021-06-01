package nlu.project.cdweb.controller;


import javax.servlet.http.HttpServletRequest;

import nlu.project.cdweb.service.*;
import nlu.project.cdweb.entity.*;
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
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
//		System.out.println("banner: "+bannerService.carousel());
//		System.out.println("battery: "+batteryService.list());
//		System.out.println("brand: "+brandService.list());
//		System.out.println("orderdetail: "+orderDetailService.list());
//		System.out.println("order: "+orderService.list());
//		System.out.println("product: "+productService.hotProducts());
//		System.out.println("ram: "+ramService.list());
//		System.out.println("rom: "+romService.list());
//		System.out.println("sale: "+saleService.list());
//		System.out.println("user: "+userService.list());
//		System.out.println("index");

		return "index";
	}

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(HttpServletRequest request,Model model) {
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
		return "home";
	}

	
}