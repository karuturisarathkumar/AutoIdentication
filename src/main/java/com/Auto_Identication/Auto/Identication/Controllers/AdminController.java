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
import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
import com.Auto_Identication.Auto.Identication.Models.Security;
import com.Auto_Identication.Auto.Identication.Services.AdminServices;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	private AdminServices adminservices;
	@Autowired
	private EmployeeDao employeedao;
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
public String aRegister(Model adminmodel,Model secmodel)
{
	Admin admin=new Admin();
	adminmodel.addAttribute("admin", admin);
	Security secure = new Security();
	secmodel.addAttribute("securityque", secure);
	return "AdminRegistration";
}
	
@PostMapping("/adminregvalidate")	
public String adminVerifyRegistration(@ModelAttribute("admin") Admin ad,@ModelAttribute("securityque") Security sec,Model model)
{
	sec.setUserId(ad.getUserId());
	ad.setSecurity(sec);
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
@GetMapping("/homeadmin")
public String adminHome(Model model)
{
	model.addAttribute("message","* Please logout at the end of the day *");
return "Adminhome";	
}
@GetMapping("/getemplist")	
public String getAllEmployees(Model model)
{
	List<BankEmployee> employeelist=adminservices.emplist();
	List<BankEmployee> bankemployeelist=new ArrayList<BankEmployee>();
	for (BankEmployee be : employeelist)
	{
		if(be.getStatus().equals("deactivate"))
		{
			bankemployeelist.add(be);
		}
	}
	model.addAttribute("employeelist", bankemployeelist);
	return "Adminwork";
}
	@GetMapping("/activate")
public String employeeActivation(@RequestParam("userid") String user,Model model)
{
	BankEmployee bankemployee=employeedao.findByUserId(user);
	bankemployee.setStatus("activate");
	BankEmployee be=employeedao.save(bankemployee);
	String status=be.getStatus();
	if(be!=null && status.equals("activate"))
	{
		model.addAttribute("message", user +"sucesfully activate");
	return "Adminhome";
	}
	else
	{
		model.addAttribute("message", user +"not activated");
		return "Adminhome";
	}
}
	@GetMapping("/autocustlist")
public String autoDefaulters(Model model)
{
		List<LoanCustomer> custlist=adminservices.customerlist();
		List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) 
		{
			if(customer.getBorrowerRating()>=8 && (customer.getAccuralStatus()==2||customer.getAccuralStatus()==3||customer.getAccuralStatus()==4||customer.getAccuralStatus()==5))
			{
				cl.add(customer);
			}
		}
		model.addAttribute("customerList", cl);
return "Adminworkofcustomer";
}
@GetMapping("/manualcustlist")
public String manualDefaulters(Model model)
{
	List<LoanCustomer> custlist=adminservices.customerlist();
	List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
	for (LoanCustomer customer : custlist) 
	{
		int due=customer.getDues()*30;
		if(due>=90 && (customer.getBorrowerRating()==5 ||customer.getBorrowerRating()==6 ||customer.getBorrowerRating()==7 || customer.getAccuralStatus()==1||customer.getAccuralStatus()==6||customer.getAccuralStatus()==7))
		{
			cl.add(customer);
		}
	}
	model.addAttribute("customerList", cl);
	return "Adminworkofcustomer";	
}
	
@GetMapping("/list")
public String getAllList(Model model)
{
	List<LoanCustomer> custlist=adminservices.customerlist();
	model.addAttribute("customerList", custlist);
return "Adminworkofcustomer";	
}

@GetMapping("/sixmonthlist")
public String sixMonth(Model model)
{
	List<LoanCustomer> custlist=adminservices.customerlist();
	List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
	for (LoanCustomer customer : custlist) 
	{
		if(customer.getDues()>=6)
		{
			cl.add(customer);
		}
	}
	model.addAttribute("custList", cl);
	return "Adminworkofcustomer";	
}

@GetMapping("/forgetUId")
public String forgetId(Model model) {
	 return "AdminForgotUserId";
}

@PostMapping("/getUserId")
public String getUserid(@RequestParam("contactNumber") String contactNumber,
		@RequestParam("question") String question,
		@RequestParam("answer") String answer,
		Model model) {
	
	System.out.println(question +" "+answer);
	 Security sc = adminservices.getSecurity(contactNumber);
	 System.out.println(sc);
	 if(sc==null)
	 {
		 model.addAttribute("message", "Your contact number is not registered with us ");
		 return "AdminForgotUserId";
	 }
	 
	if(question.equals(sc.getQuestion()) && answer.equals(sc.getAnswer()))
	 {
		 model.addAttribute("message", "Your User Id is :<b>"+sc.getUserId());
		 return "AdminForgotUserId";	 
	 }
	 else
	 {
		 model.addAttribute("message", "Invalid secret question credentials ");
		 return "AdminForgotUserId";	
		
	 }	
}	
@GetMapping("/forgetpwd")
public String forgetPwd(Model model) {
	
	return "AdminForgotpassword";
}
@PostMapping("/getpwd")
public String getPassword(@RequestParam("userId") String userid,
		@RequestParam("question") String que,
		@RequestParam("answer") String ans,
		   Model model,HttpSession session) {
	Security sc = adminservices.getSecuritypwd(userid);
	System.out.println(sc);
	 if(sc==null)
	 {
		 model.addAttribute("message", "Your UserId is not registered with us ");
		 return "AdminForgotpassword";
	 }
	 
	if(que.equals(sc.getQuestion()) && ans.equals(sc.getAnswer()))
	 {
		// model.addAttribute("message", "Your password is :<b>"+sc.getPassword());
		
		session.setAttribute("userid", sc.getUserId());
		 
		 return "AdminResetPassword";	 
	 }
	 else
	 {
		 model.addAttribute("message", "Invalid secret question credentials ");
		 return "AdminForgotpassword";
		
	 }	
}

@PostMapping("/resetpassword")
public String resetPassword(@RequestParam("password")String pwd,
		@RequestParam("confirmationpassword")String cpwd,Model model,HttpSession session) {
	
	String userid = (String)session.getAttribute("userid");
	
	//System.out.println(userid);
	
		if(pwd.equals(cpwd)) {
			
			Admin ad = adminservices.getuserdata(userid);			
			ad.setPassword(pwd);
			ad.setConfirmationpassword(cpwd);
			
			boolean status = adminservices.updatePassword(ad);
			if(status == true) {
				
				model.addAttribute("message", "reset password Sucessfully");
				return "AdminResetPassword";
			}
			else {
				model.addAttribute("message", "not reset");
				return "AdminResetPassword";
			}
		}
		else {
			model.addAttribute("message", "new password and conformation are not same");
			return "AdminResetPassword";

		}	
}

@GetMapping("/logout")
public String logOut()
{
	return "home";
}



	
	
	
	
	
}
