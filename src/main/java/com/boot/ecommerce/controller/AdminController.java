package com.boot.ecommerce.controller;


import java.security.Principal;
import java.util.Arrays;
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
import com.boot.ecommerce.entity.Temp;
import com.boot.ecommerce.entity.User;
import com.boot.ecommerce.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	private int id;
	private User user;
	
	
	@GetMapping("/adminHome")
	public String adminHome(Principal principal,Model model)
	{
		String name=principal.getName();
		id=adminService.getUserId(name);
		user=adminService.getUserById(id);
		String welcome="Welcome "+user.getFirstName();
		model.addAttribute("welcome",welcome);
		return "adminHome";
	}
	
	@GetMapping("/addProduct")
	public String addProduct(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "addProduct";
	}
	
	
	@GetMapping("/reAddProduct")
	public String reAddProduct(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "reAddProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product,Model model)
	{
		String name=product.getName().trim();
		int price =product.getPrice();
		int profit=product.getProfit();
		if(name!="" && price>0 && profit>=0)
		{
			adminService.saveProduct(product);
			return "redirect:/admin/viewProducts";
		}
		else
		{ 
			return "redirect:/admin/reAddProduct";
		}
		
	}
	@GetMapping("/viewProducts")
	public String viewProducts(Model model)
	{
		return findPaginated(1,model);
	}
	@GetMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable(value="id") int id,Model model)
	{
		Product product=adminService.getProductById(id);
		model.addAttribute("product",product);
		return "updateProduct";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id") int id,Model model)
	{
		adminService.deleteProduct(id);
		return "redirect:/admin/viewProducts";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo") int pageNo,Model model)
	{
		int pageSize=4;
	    Page<Product> page=adminService.findPaginated(pageNo,pageSize);
	    List<Product> listProduct=page.getContent();
	    
	    model.addAttribute("currentPage",pageNo);
	    model.addAttribute("totalPages",page.getTotalPages());
	    model.addAttribute("totalItems",page.getTotalElements());
	    model.addAttribute("listProduct",listProduct);
	 
	    return "viewProducts";
		
	}
	
	@GetMapping("/showStatistics")
	public String showStatistics(Model model)
	{
		List<Integer> listSlotId=adminService.getListSlotId();
		int sold=listSlotId.size();
		model.addAttribute("sold",sold);
		return "showStatistics";
	}
	
	
	
}
