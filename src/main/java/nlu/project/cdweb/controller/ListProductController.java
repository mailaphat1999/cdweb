package nlu.project.cdweb.controller;


import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ListProductController {

	@Autowired
	BatteryService batteryService;
	@Autowired
	BrandService brandService;
	@Autowired
	ProductService productService;
	@Autowired
	RamService ramService;
	@Autowired
	RomService romService;
	@Autowired
	PriceService priceService;

	@RequestMapping(value = "/product",method = RequestMethod.GET)
	public String listProducts(HttpServletRequest request,Model model) {
		model.addAttribute("brand",brandService.list());
		model.addAttribute("battery",batteryService.list());
		model.addAttribute("ram",ramService.list());
		model.addAttribute("rom",romService.list());
		model.addAttribute("price",priceService.list());
		return "product";
	}

	
}