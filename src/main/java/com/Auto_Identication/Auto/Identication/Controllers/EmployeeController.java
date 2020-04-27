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
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/forgetUserId")
	public String forgetId(Model model) {
		 return "ForgotUserid";
	}
	
	@PostMapping("/getUserId")
	public String getUserid(@RequestParam("contactNumber") String contactNumber,
			@RequestParam("question") String question,
			@RequestParam("answer") String answer,
			Model model) {
		
		System.out.println(question +" "+answer);
		 Security sc = employeeservices.getSecurity(contactNumber);
		 System.out.println(sc);
		 if(sc==null)
		 {
			 model.addAttribute("message", "Your contact number is not not registered with us ");
			 return "ForgotUserid";
		 }
		 
		if(question.equals(sc.getQuestion()) && answer.equals(sc.getAnswer()))
		 {
			 model.addAttribute("message", "Your User Id is :<b>"+sc.getUserId());
			 return "ForgotUserid";	 
		 }
		 else
		 {
			 model.addAttribute("message", "Invalid secret question credentials ");
			 return "ForgotUserid";	
			
		 }
		  
		
	}	
	@GetMapping("/forgetpassword")
	public String forgetPwd(Model model) {
		
		return "Forgotpassword";
	}
	@PostMapping("/getpwd")
	public String getPassword(@RequestParam("userId") String userid,
			@RequestParam("question") String que,
			@RequestParam("answer") String ans,
			   Model model,HttpSession session) {
		Security sc = employeeservices.getSecuritypwd(userid);
		System.out.println(sc);
		 if(sc==null)
		 {
			 model.addAttribute("message", "Your UserId is not not registered with us ");
			 return "Forgotpassword";
		 }
		 
		if(que.equals(sc.getQuestion()) && ans.equals(sc.getAnswer()))
		 {
			// model.addAttribute("message", "Your password is :<b>"+sc.getPassword());
			
			session.setAttribute("userid", sc.getUserId());
			 
			 return "ResetPassword";	 
		 }
		 else
		 {
			 model.addAttribute("message", "Invalid secret question credentials ");
			 return "Forgotpassword";
			
		 }
		
	}
	
	@PostMapping("/resetpwd")
	public String resetPassword(@RequestParam("password")String pwd,
			@RequestParam("confirmationpassword")String cpwd,Model model,HttpSession session) {
		
		String userid = (String)session.getAttribute("userid"); 
		
			
			if(pwd.equals(cpwd)) 
			{
				BankEmployee be = employeeservices.getuserdata(userid);			
				be.setPassword(pwd);
				be.setConfirmationpassword(cpwd);
				
				boolean status = employeeservices.updatePassword(be);
				if(status == true) {
					
					model.addAttribute("message", "reset password Sucessfully");
					return "ResetPassword";
				}
				else {
					model.addAttribute("message", "not reset");
					return "ResetPassword";
				}
				
			}
			else 
			{
				model.addAttribute("message", "new password and conformation are not same");
				return "ResetPassword";
			}		
	}
}
	
	

