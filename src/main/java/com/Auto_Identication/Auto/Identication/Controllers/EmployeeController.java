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
	
	@GetMapping("/duelessthree")
	public String duelistlessthree(Model model)
	{
		List<LoanCustomer> list3=employeeservices.customerlist();
		List<LoanCustomer> dt=new ArrayList<LoanCustomer>();
		for (LoanCustomer dues : list3)
		{
			if(dues.getDues()<3)
			{
				dt.add(dues);
			}
			
		}
		model.addAttribute("duelessthan3",dt);
		return "employeeworkfromcustomer";
	}
	@GetMapping("/duelesssix")
	public String duelistlesssix(Model model)
	{
		List<LoanCustomer> list6=employeeservices.customerlist();
		List<LoanCustomer> ds=new ArrayList<LoanCustomer>();
		for (LoanCustomer due : list6)
		{
			if(due.getDues()>=3 && due.getDues()<6 )
			{
				ds.add(due);
			}
			
		}
		model.addAttribute("duelessthan3",ds);
		return "employeeworkfromcustomer";
	}
	@GetMapping("/duelesstwelve")
	public String duelistlesstwelve(Model model)
	{
		List<LoanCustomer> list12=employeeservices.customerlist();
		List<LoanCustomer> dtw=new ArrayList<LoanCustomer>();
		for (LoanCustomer du : list12)
		{
			if(du.getDues()>=6 && du.getDues()<12)
			{
				dtw.add(du);
			}
			
		}
		model.addAttribute("duelessthan3",dtw);
		return "employeeworkfromcustomer";
	}
	@GetMapping("/duegreatertwelve")
	public String duelistgreatertwelve(Model model)
	{
		List<LoanCustomer> list13=employeeservices.customerlist();
		List<LoanCustomer> dth=new ArrayList<LoanCustomer>();
		for (LoanCustomer d : list13)
		{
			if(d.getDues()>=6 && d.getDues()<12)
			{
				dth.add(d);
			}
			
		}
		model.addAttribute("duelessthan3",dth);
		return "employeeworkfromcustomer";
	}
	@GetMapping("/duelist")
	public String duelist(Model model)
	{
		List<LoanCustomer> list=employeeservices.customerlist();
		List<LoanCustomer> l=new ArrayList<LoanCustomer>();
		for (LoanCustomer lc : list)
		{
			if(lc.getDues()<=3)
			{
			model.addAttribute("message","Late payment charges are applied");
			
			}
			else if(lc.getDues()>3 && lc.getDues()<=6)
			{
				model.addAttribute("message","Remainder sent");
				
			}
			else if(lc.getDues()>6 && lc.getDues() <12)
			{
				model.addAttribute("message","card to be blocked");
				
			}
			else
			{
				model.addAttribute("message","card was cancelled");
				
			}
		}
		return "employeeworkfromcustomer";
		
	}	
	}
	
	
	

