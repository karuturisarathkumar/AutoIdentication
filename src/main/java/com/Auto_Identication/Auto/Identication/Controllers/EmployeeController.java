package com.Auto_Identication.Auto.Identication.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;


import com.Auto_Identication.Auto.Identication.Dao.EmployeeDao;
import com.Auto_Identication.Auto.Identication.Dao.LoanCustomerDao;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.BankEmployeeLogin;
import com.Auto_Identication.Auto.Identication.Models.Issues;
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
			
			return "employeehome";
		}
		else if(res==2)
		{
			model.addAttribute("message","please wait for admin approval");
			return "login";
		}
		else if(res==3)
		{
			model.addAttribute("message", "please check the details");
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
			if(loancustomer.getStatus().equals("defaulter"))
			{
			customers.add(loancustomer);
			}
		}
		model.addAttribute("custlist",customers);
		return "employeeworkforcustomer";
	}

	@GetMapping("/homeemp")
	public String empHome(Model model)
	{
		
	    
		return "employeehome";
	}
	
	@GetMapping("/details")
	public String empDetails(@RequestParam("id") int res,Model cusmodel,Model model,HttpSession session)
	{
		session.setAttribute("refer", res);
		LoanCustomer lc=loandao.findByaccountNumber(res);
		cusmodel.addAttribute("customer",lc);
		model.addAttribute("card",lc.getCard());
		return "customerdueverify";
	}
	@GetMapping("/duelessthree")
	public String duelistlessthree(Model model)
	{
		List<LoanCustomer> list3=employeeservices.customerlist();
		List<LoanCustomer> dt=new ArrayList<LoanCustomer>();
		if(list3!=null)
		{
		for (LoanCustomer dues : list3)
		{
			if(dues.getDues()<3)
			{
				dt.add(dues);
			}
			
		}
		System.out.println(dt);
		model.addAttribute("custlist",dt);
		return "employeeworkforcustomer";
		}
		else
		{
			model.addAttribute("message", "no one is their");
			return "employeehome";
		}
	}
	@GetMapping("/duelesssix")
	public String duelistlesssix(Model model)
	{
		List<LoanCustomer> list6=employeeservices.customerlist();
		List<LoanCustomer> ds=new ArrayList<LoanCustomer>();
		if(list6!=null)
		{
		for (LoanCustomer due : list6)
		{
			if(due.getDues()>=3 && due.getDues()<6 )
			{
				ds.add(due);
			}
			
		}
		model.addAttribute("custlist",ds);
		return "employeeworkforcustomer";
		}
		else
		{
			model.addAttribute("message","no one is their");
			return "employeehome";
		}
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
		model.addAttribute("custlist",dtw);
		return "employeeworkforcustomer";
	}
	@GetMapping("/duegreatertwelve")
	public String duelistgreatertwelve(Model model)
	{
		List<LoanCustomer> list13=employeeservices.customerlist();
		List<LoanCustomer> dth=new ArrayList<LoanCustomer>();
		if(list13!=null) {
		for (LoanCustomer d : list13)
		{
			if(d.getDues()>=12)
			{
				dth.add(d);
			}
			
		}
		model.addAttribute("custlist",dth);
		return "employeeworkforcustomer";
		}
		else {
			model.addAttribute("message","No defaulters");
			return "employeeworkforcustomer";
		}
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

	
	
	@GetMapping("/cards")
	public String customerCards(Model model)
	{
		return "search";
	}
	@PostMapping("/getCard")
	public String searchCustomer(@RequestParam("number") int res,Model model,HttpSession session)
	{
session.setAttribute("account", res);
		LoanCustomer lc=loandao.findByaccountNumber(res);	
		if(lc==null)
		{
			model.addAttribute("message", "There is no customer");
			return "employeehome";
		}
		model.addAttribute("card",lc.getCard());
		return "cardstatus";
	}
	@GetMapping("/getlist")
	public String getlist(Model model) {
	//public List<Issues> getlist(){
		//return issuesdao.findAll();
		List<Issues> issues = employeeservices.findAll();
		model.addAttribute("issues", issues);
		return "showIssues";
	}
	@PostMapping("/reactive")
	public String reActivate(@RequestParam("reason") String rs,Model model,HttpSession session)
	{
		Date d=new Date();
		int res=(int) session.getAttribute("account");
		LoanCustomer lc=loandao.findByaccountNumber(res);
		if(lc.getCard().getCardStatus().equals("deactive"))
		{
			lc.getCard().setCardStatus("Re-active");
			lc.getCard().setExpDate(d);
			lc.getCard().setReActivationReason(rs);
			LoanCustomer cardloan=loandao.save(lc);
			if(cardloan!=null)
			{
				model.addAttribute("message",lc.getCustomerName()+  "card is re-activated and message was sent to " +lc.getCustomerName());
				return "employeehome";
			}
			else
			{
				model.addAttribute("message",lc.getCustomerName()+  "card is not re-cativated");
				return "employeehome";
			}
		}
		model.addAttribute("message",lc.getCustomerName()+  "card isalready in re-actived");
		return "employeehome";
	}
	
	@GetMapping("/setDec")
	public String goToDeactive(Model model,HttpSession session)
	{
		int res=(int) session.getAttribute("account");
		LoanCustomer lc=loandao.findByaccountNumber(res);	
		if(lc==null)
		{
			model.addAttribute("message", "There is no customer");
			return "employeehome";
		}
		model.addAttribute("card",lc.getCard());
		return "deactivates";
	}
		
		
		
	
	
	
	
	@PostMapping("/blockcard")
	public String deActivate(@RequestParam("reason") String rs,Model model,HttpSession session)
	{
		Date d=new Date();
		int res=(int) session.getAttribute("account");
		LoanCustomer lc=loandao.findByaccountNumber(res);
		if(lc.getCard().getCardStatus().equals("active"))
		{
			lc.getCard().setCardStatus("deactive");
			lc.getCard().setExpDate(d);
			lc.getCard().setReActivationReason(rs);
			LoanCustomer cardloan=loandao.save(lc);
			if(cardloan!=null)
			{
				model.addAttribute("message",lc.getCustomerName()+  "card is decativated");
				return "employeehome";
			}
			else
			{
				model.addAttribute("message",lc.getCustomerName()+  "card is not decativated");
				return "employeehome";
			}
		}
		model.addAttribute("message",lc.getCustomerName()+ "card is already  deactived");
		return "employeehome";
	}
	@GetMapping("/charges")
	public String applyCharges(@RequestParam("id") int res,Model model)
	{
		LoanCustomer lc=loandao.findByaccountNumber(res);
		double f=lc.getFine();
		double vf=100*lc.getDues();
		if(f==vf)
		{
			model.addAttribute("message",lc.getFine()+"already charges applied");
			return "employeehome";
		}
		else
		{
			lc.setFine(vf);
			LoanCustomer sl=loandao.save(lc);
			if(sl==null)
			{
				model.addAttribute("message","charges not applied");
				return "employeehome";
			}
			else
			{
				model.addAttribute("message","charges applied");
				return "employeehome";
			}
		}

	}	

	@GetMapping("/alert")
	public String message(Model model)
	{
		model.addAttribute("message","message sent succesfully");
		return "employeehome";
	}
	@GetMapping("/pay")
	public String payAmount(Model model)
	{
		return "moneyPay";
	}
	
	@GetMapping("/verPay")
	public String verifyAmount(@RequestParam("amount") int amm,Model model,HttpSession session)
	{
		System.out.println(amm);
	int res=(int)session.getAttribute("refer");
	LoanCustomer lc=loandao.findByaccountNumber(res);
	int paid=lc.getMoneyPaid()+amm;
	lc.setMoneyPaid(paid);
	LoanCustomer loan=loandao.save(lc);
	if(loan!=null)
	{
		model.addAttribute("message", amm+" is successfully paid");
		return "employeehome";
	}
	else
	{
		model.addAttribute("message", "something went wrong");
		return "employeehome";
	}
	
	}
	
	@GetMapping("/empsetvalidate")
	public String statusValidate(@RequestParam("id") int res,Model model)
	{
		System.out.println(res);
		
	LoanCustomer lc=loandao.findByaccountNumber(res);
	lc.setStatus("validate");
	lc.setAccuralStatus(9);
	lc.setBorrowerRating(1);
	LoanCustomer lc1=loandao.save(lc);
	if(lc1!=null)
	{
	    model.addAttribute("message",lc.getCustomerName()+" is now a validator");
		return "employeehome";
	}
	else
	{
		 model.addAttribute("message",lc.getCustomerName()+" is not updated as validator");
			return "employeehome";
	}
	}

	@GetMapping("/empsetwaver")
	public String statusAutowaver(@RequestParam("id") int res,Model model)
	{
	LoanCustomer lc=loandao.findByaccountNumber(res);
	lc.setStatus("autowaver");
	lc.setAccuralStatus(8);
	lc.setBorrowerRating(3);
	LoanCustomer lc1=loandao.save(lc);
	if(lc1!=null)
	{
	    model.addAttribute("message",lc.getCustomerName()+" is now a autowaver");
		return "employeehome";
	}
	else
	{
		 model.addAttribute("message",lc.getCustomerName()+" is not updated as autowaver");
			return "employeehome";
	}
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
	

	@GetMapping("/empsetdefault")
	public String statusDefaulter(@RequestParam("id") int res,Model model)
	{
	LoanCustomer lc=loandao.findByaccountNumber(res);
	lc.setStatus("defaulter");
	if(lc.getDues()>=8)
	{
		lc.setBorrowerRating(10);
		lc.setAccuralStatus(5);
	}
	else if(lc.getDues()>=5 && lc.getDues()<8)
	{
		lc.setBorrowerRating(7);
		lc.setAccuralStatus(7);
		
	}
	LoanCustomer lc1=loandao.save(lc);
	if(lc1!=null)
	{
	    model.addAttribute("message",lc.getCustomerName()+" is now a defaulter");
		return "employeehome";
	}
	else
	{
		 model.addAttribute("message",lc.getCustomerName()+" is not updated as defaulter");
			return "employeehome";
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
	
	@PostMapping("/getAccountNumber")
	public String searchAccountNumber(@RequestParam("num") int number,Model model)
	{
		LoanCustomer lc=loandao.findByaccountNumber(number);
		if(lc!=null)
		{
			if(lc.getStatus().equals("defaulter"))
			{
		model.addAttribute("cust", lc);
		return  "empsearch";
			}
			else
			{
				model.addAttribute("message",lc.getCustomerName()+" is not a defaulter");
				return "employeehome";
			}
		}
		else
		{
			model.addAttribute("message","account number not found");
			return "employeehome";
		}
		}
	
	}

	
	


