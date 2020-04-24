package com.Auto_Identication.Auto.Identication.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Auto_Identication.Auto.Identication.Dao.EmployeeDao;
import com.Auto_Identication.Auto.Identication.Dao.LoanCustomerDao;
import com.Auto_Identication.Auto.Identication.Dao.SecurityDao;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.BankEmployeeLogin;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
import com.Auto_Identication.Auto.Identication.Models.Security;
import com.Auto_Identication.Auto.Identication.Services.EmployeeServices;

@Controller
@RequestMapping(value="/emp")
public class EmployeeController 
{
	@Autowired
	private EmployeeServices employeeservices;
	@Autowired
	private SecurityDao securedao;
	@Autowired
	private LoanCustomerDao loandao;
	@GetMapping("/")
public String empLogin(Model model)
{
		BankEmployeeLogin bankemployeelogin=new BankEmployeeLogin();
		model.addAttribute("bankemployeelogin", bankemployeelogin);
	return "login";
}
	@PostMapping("/verifylogin")
public String empLoginVerify(@ModelAttribute("bankemployeelogin") BankEmployeeLogin bel,Model model,HttpSession session)
{
		session.setAttribute("userid", bel.getUserId());
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
public String empRegister(Model empmodel,Model secmodel)
{
		BankEmployee bankemployee=new BankEmployee();
		empmodel.addAttribute("bankemployee", bankemployee);
		
		Security secure=new Security();
		secmodel.addAttribute("secure", secure);
	return "registration";	
}
	@PostMapping("/verifyregister")
public String verifyEmpRegister(@ModelAttribute("bankemployee") BankEmployee be,@ModelAttribute("secure") Security sec,Model model)
{
		sec.setUserId(be.getUserId());;
	be.setSecurity(sec);
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
	@GetMapping("/defaultlist")
	public String defaulterList(Model model)
	{
		List<LoanCustomer> cl=employeeservices.customerlist();
		List<LoanCustomer> customers=new ArrayList<LoanCustomer>();
		for (LoanCustomer loancustomer : cl)
		{
			
			customers.add(loancustomer);
		}
		model.addAttribute("custlist",customers);
		return "employeeworkforcustomer";
	}
	
	@GetMapping("/homeemp")
	public String empHome(Model model)
	{
		model.addAttribute("message","* Please logout at the end of the day *");
	    
		return "emphome";
	}
	
	@GetMapping("/details")
	public String empDetails(@RequestParam("id") int res,Model cusmodel,Model model)
	{
		LoanCustomer lc=loandao.findByaccountNumber(res);
		System.out.println(lc);
		cusmodel.addAttribute("customer",lc);
		model.addAttribute("card",lc.getCard());
		return "customerdueverify";
	}
	
	@GetMapping("/cards")
	public String customerCards(Model model)
	{
		return "search";
	}
	@PostMapping("/getCard")
	public String searchCustomer(@RequestParam("number") int res,Model model)
	{
		LoanCustomer lc=loandao.findByaccountNumber(res);
		if(lc==null)
		{
			model.addAttribute("message", "There is no customer");
			return "emphome";
		}
		model.addAttribute("card",lc.getCard());
		return "search";
	}
	
	
	
	
	@GetMapping("/forgot")
	public String forgotPassword(Model model)
	{
		Security secure=new Security();
		model.addAttribute("passwordsecure",secure);
		return "security";
	}
	
	@PostMapping("/empforget")
	public String verifyForgot(@ModelAttribute("passwordsecure") Security sec,Model  model)
	{
		System.out.println(sec);
		System.out.println(sec.getUserId());
		Security s=securedao.findByuserId(sec.getUserId());
		BankEmployeeLogin bl=new BankEmployeeLogin();
		model.addAttribute("bankemployeelogin", bl);
		System.out.println(s);
		if(s!=null)
		{
		if(s.getQuestion().equals(sec.getQuestion()))
		{
			return "newpassword";
		}
		}
		model.addAttribute("message","you are not the user");
		return "login";
		
	}
	
}

