package com.boot.ecommerce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	@GetMapping("/success")
	public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException
	{
        
        String role =  authResult.getAuthorities().toString();
        
        if(role.contains("ROLE_ADMIN")){
         response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/adminHome"));                            
         }
         else if(role.contains("ROLE_USER")) {
             response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user/userHome"));
         }

        
    }
	
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
		
}
