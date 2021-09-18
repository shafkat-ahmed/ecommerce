package com.boot.ecommerce.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.ecommerce.entity.Product;
import com.boot.ecommerce.entity.Sale;
import com.boot.ecommerce.entity.Temp;
import com.boot.ecommerce.entity.User;
import com.boot.ecommerce.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private int id;
	private User user;
	
	@GetMapping("/userHome")
	public String userHome(Principal principal,Model model)
	{
		String name=principal.getName();
		id=userService.getUserId(name);
		user=userService.getUserById(id);
		Temp temp=new Temp();
		String welcome="Welcome "+user.getFirstName();
		model.addAttribute("welcome",welcome);
		model.addAttribute("temp",temp);
		return "userHome";
	}
	@PostMapping("/searchType")
	public String searchType(@ModelAttribute("temp") Temp temp,Model model)
	{
		String type=temp.getType();
		List<Product> listProduct=userService.getProductByType(type);
		String header=type+" List";
		model.addAttribute("header",header);
		model.addAttribute("listProduct",listProduct);
		return "searchResult";
	}
	
	@GetMapping("/buyProduct/{id}")
	public String buyProduct(@PathVariable(value="id") int id,Model model)
	{
		Product product=userService.getProductById(id);
		Sale sale=new Sale();
		sale.setUser(user);
	    sale.setProduct(product);
		userService.saveSale(sale);
		return "redirect:/user/viewPurchasedProducts";
	}
	
	@GetMapping("/viewPurchasedProducts")
	public String viewPurchasedProducts(Model model)
	{
		List<Sale> listSale=userService.getUserSales(user);
		model.addAttribute("listSale", listSale);
		return "viewPurchasedProducts";
		
		
	}
	@GetMapping("/viewAllProducts")
	public String viewAllProducts(Model model)
	{
		return findPaginated(1,model);
	}
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo") int pageNo,Model model)
	{
		int pageSize=5;
	    Page<Product> page=userService.findPaginated(pageNo,pageSize);
	    List<Product> listProduct=page.getContent();
	    
	    model.addAttribute("currentPage",pageNo);
	    model.addAttribute("totalPages",page.getTotalPages());
	    model.addAttribute("totalItems",page.getTotalElements());
	    model.addAttribute("listProduct",listProduct);
	 
	    return "viewAllProducts";
		
	}
	
}
