package com.Auto_Identication.Auto.Identication.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private AdminServices adminservices;
	@GetMapping("/")
public String aLogin(Model model)
{
		AdminLogin adminlogin=new AdminLogin();
		model.addAttribute("adminlogin", adminlogin);
	return "AdminLogin";
}
	@PostMapping("/logadmin")
public String adminVerifyLogin(@ModelAttribute("adminlogin") AdminLogin al,Model model,HttpSession session)

{
		session.setAttribute("userid",al.getUserId());
		int res=adminservices.getAdmin(al);
		if(res==1)
		{
			
			return "Adminhome";
		}
		else if(res==2)
		{
			model.addAttribute("message", "your are not yet registered");
			return "AdminLogin";
		}
		model.addAttribute("message", "please check your details");
	return "AdminLogin";
}
	
@GetMapping("/regadmin")	
public String aRegister(Model model)
{
	Admin admin=new Admin();
	model.addAttribute("admin", admin);
	return "AdminRegistration";
}
	
@PostMapping("/adminregvalidate")	
public String adminVerifyRegistration(@ModelAttribute("admin") Admin ad,Model model)
{
	System.out.println(ad);
	int res=adminservices.storeAdmin(ad);
	AdminLogin adminlogin=new AdminLogin();
	model.addAttribute("adminlogin", adminlogin);
	if(res==1)
	{
		model.addAttribute("message", "succesfully registered");
		return "AdminLogin";
	}
	else if(res==2)
	{
		model.addAttribute("message", "already registered");
		return "AdminLogin";
	}
	model.addAttribute("message", "something went wrong");
	return "AdminLogin";
}
	
	
	
	
	
	
	
	
}
