package com.Auto_Identication.Auto.Identication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Services.AdminServices;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	private AdminServices adminservices;
	@GetMapping("/")
public String aLogin(Model model)
{
		AdminLogin adminlogin=new AdminLogin();
		model.addAttribute("adminlogin", adminlogin);
	return "login";
}
	@PostMapping("/logadmin")
public String adminVerifyLogin(@ModelAttribute("adminlogin") AdminLogin al,Model model)
{
	return "adminhome";
}
	
@GetMapping("/regadmin")	
public String aRegister(Model model)
{
	Admin admin=new Admin();
	model.addAttribute("admin", admin);
	return "register";
}
	
@PostMapping("/verifyadminreg")	
public String aVerifyRegistration(@ModelAttribute("admin") Admin ad,Model model)
{
	int res=adminservices.storeAdmin(ad);
	if(res==1)
	{
		return "login";
	}
	else if(res==2)
	{
		return "login";
	}
	
	return "login";
}
	
	
	
	
	
	
	
	
}
