package com.Auto_Identication.Auto.Identication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.BankEmployeeLogin;
import com.Auto_Identication.Auto.Identication.Services.EmployeeServices;

@Controller
@RequestMapping(value="/emp")
public class EmployeeController 
{
	@Autowired
	private EmployeeServices employeeservices;
	@GetMapping("/")
public String empLogin(Model model)
{
		BankEmployeeLogin bankemployeelogin=new BankEmployeeLogin();
		model.addAttribute("bankemployeelogin", bankemployeelogin);
	return "login";
}
	@PostMapping("/verifylogin")
public String empLoginVerify(@ModelAttribute("bankemployeelogin") BankEmployeeLogin bel,Model model)
{
		int res=employeeservices.getBankEmployee(bel);
		if(res==1)
		{
			
			return "emphome";
		}
		else if(res==2)
		{
			model.addAttribute("message","please wait for admin approval");
			return "login";
		}
		else if(res==3)
		{
			model.addAttribute("message", "please check thye details");
			return "login";
		}
		model.addAttribute("message","you are not registered please regsiter");
	return "login";
}
	@GetMapping("/register")
public String empRegister(Model model)
{
		BankEmployee bankemployee=new BankEmployee();
		model.addAttribute("bankemployee", bankemployee);
	return "registration";	
}
	@PostMapping("/verifyregister")
public String verifyEmpRegister(@ModelAttribute("bankemployee") BankEmployee be,Model model)
{
		be.setStatus("deactivate");
	int res=employeeservices.storeEmployee(be);
	BankEmployeeLogin bankemployeelogin=new BankEmployeeLogin();
	model.addAttribute("bankemployeelogin", bankemployeelogin);
	if(res==1)
	{
		model.addAttribute("message","you are succesfully registered" );
		return "login";
	}
	else if(res==2)
	{
		model.addAttribute("message", "you are already registered");
		return "login";
	}
	else
	{
		model.addAttribute("message", "something went wrong");
	return "login";
	}
}
	
	
	
	
	
	
	
	
}

