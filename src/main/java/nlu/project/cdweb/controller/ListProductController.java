package nlu.project.cdweb.controller;


import nlu.project.cdweb.custom.Config;
import nlu.project.cdweb.entity.Price;
import nlu.project.cdweb.entity.Product;
import nlu.project.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;


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
	public String listProducts(HttpServletRequest request, HttpSession session, Model model) {
		model.addAttribute("brand",brandService.list());
		model.addAttribute("battery",batteryService.list());
		model.addAttribute("ram",ramService.list());
		model.addAttribute("rom",romService.list());
		model.addAttribute("price",priceService.list());
		DuplicateCode.setCartAndUser(session,model);

		String parameter = "";boolean firstPara = false;
		List<Product> listProduct = productService.list();
		if(request.getParameter("ram")!=null){
			if(!firstPara) {parameter+="?ram="+request.getParameter("ram");firstPara = true;}else parameter += "&ram="+request.getParameter("ram");
			listProduct = listProduct.stream().filter(product -> product.getRam().getId().equals(request.getParameter("ram"))).collect(Collectors.toList());

		}
		if(request.getParameter("rom")!=null){
			if(!firstPara) {parameter+="?rom="+request.getParameter("rom");firstPara = true;}else parameter += "&rom="+request.getParameter("rom");
			listProduct = listProduct.stream().filter(product -> product.getRom().getId().equals(request.getParameter("rom"))).collect(Collectors.toList());
		}
		if(request.getParameter("battery")!=null){
			if(!firstPara) {parameter+="?battery="+request.getParameter("battery");firstPara = true;}else parameter += "&battery="+request.getParameter("battery");
			listProduct = listProduct.stream().filter(product -> product.getBattery().getId().equals(request.getParameter("battery"))).collect(Collectors.toList());
		}
        if(request.getParameter("brand")!=null){
			if(!firstPara) {parameter+="?brand="+request.getParameter("brand");firstPara = true;}else parameter += "&brand="+request.getParameter("brand");
            listProduct = listProduct.stream().filter(product -> product.getBrand().getId().equals(request.getParameter("brand"))).collect(Collectors.toList());
        }
		if(request.getParameter("price")!=null){
			if(!firstPara) {parameter+="?price="+request.getParameter("price");firstPara = true;}else parameter += "&price="+request.getParameter("price");
			Price price = priceService.findByID(request.getParameter("price")).get();
			if(price.getStart()<price.getEnd())
			listProduct = listProduct.stream().filter(product -> product.getPrice()>price.getStart() && product.getPrice()<price.getEnd()).collect(Collectors.toList());
			else listProduct = listProduct.stream().filter(product -> product.getPrice()>price.getStart()).collect(Collectors.toList());
		}
		int page = 1;
		if(request.getParameter("page")!=null){
			try{
			page = Integer.parseInt(request.getParameter("page"));
			}catch (NumberFormatException e){
				page = 1;
			}
		}
		int maxPage = listProduct.size()/Config.LISTPRODUCT + 1;
		page = page>maxPage?maxPage:page;

		model.addAttribute("parameter",parameter);
		model.addAttribute("currentPage",page);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("listProduct",listProduct.subList(  (page-1) * Config.LISTPRODUCT, Math.min(page * Config.LISTPRODUCT, listProduct.size())));
		return "product";
	}

	
}