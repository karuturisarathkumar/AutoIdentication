package com.Auto_Identication.Auto.Identication.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Auto_Identication.Auto.Identication.Dao.AdminDao;
import com.Auto_Identication.Auto.Identication.Dao.EmployeeDao;
import com.Auto_Identication.Auto.Identication.Dao.IssuesDao;
import com.Auto_Identication.Auto.Identication.Dao.LoanCustomerDao;
import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.Card;
import com.Auto_Identication.Auto.Identication.Models.Issues;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
import com.Auto_Identication.Auto.Identication.Models.Security;
import com.Auto_Identication.Auto.Identication.Services.AdminServices;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminServices adminservices;
	@Autowired
	private EmployeeDao employeedao;
	@Autowired
	private LoanCustomerDao loandao;
	@Autowired
	private IssuesDao issuesdao;
	@Autowired
	private EmployeeDao empdao;
	
	@Autowired
	private AdminDao admindao;
	
	@GetMapping("/")
	public String aLogin(Model model) {
		AdminLogin adminlogin = new AdminLogin();
		model.addAttribute("adminlogin", adminlogin);
		return "AdminLogin";
	}
	
	@GetMapping("/issues")
	public String issues(Model model) {
		model.addAttribute("logissue", new Issues());
		
		return "issues";
	}
	@PostMapping("/issue")
	public String issue(@ModelAttribute("logissue") Issues il,Model model)
	{
       if(il.getRole().equals("employee"))
       {
    	  BankEmployee bk= empdao.findByUserId(il.getUserId());
       if(bk!=null)
       {
		Issues iss=issuesdao.save(il);
		if(iss!=null)
		{
		model.addAttribute("message", "Your issue is sent to the technical team");
	
		return  "home";
	    }
		else
		{
			model.addAttribute("message","something went wrong");
			return "home";
		}
       }
       else
       {
    	   model.addAttribute("message","you are not the employee");
			return "home";
       }
       }
       else
       {
    	   Admin ad=admindao.findByuserId(il.getUserId());
    	   if(ad!=null)
           {
    		Issues iss=issuesdao.save(il);
    		if(iss!=null)
    		{
    		model.addAttribute("message", "Your issue is sent to the technical team");
    	
    		return  "home";
    	    }
    		else
    		{
    			model.addAttribute("message","something went wrong");
    			return "home";
    		}
           }
    	   else
           {
        	   model.addAttribute("message","you are not the admin");
    			return "home";
           }
       }
		
	}

	@PostMapping("/logadmin")
	public String adminVerifyLogin(@ModelAttribute("adminlogin") AdminLogin al, Model model, HttpSession session)

	{
		session.setAttribute("userid", al.getUserId());
		int res = adminservices.getAdmin(al);
		if (res == 1) {
			return "sampleadminhome";
		} else if (res == 2) {
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
	else
	{
		model.addAttribute("message", "something went wrong");

		return "AdminLogin";
	}
}


	

	@GetMapping("/homeadmin")
	public String adminHome(Model model) {
		
		return "sampleadminhome";
	}

	@GetMapping("/getemplist")
	public String getAllEmployees(Model model) {
		List<BankEmployee> employeelist = adminservices.emplist();
		List<BankEmployee> bankemployeelist = new ArrayList<BankEmployee>();
		if(employeelist!=null)
		{
		for (BankEmployee be : employeelist) {
			if (be.getStatus().equals("deactivate")) {
				bankemployeelist.add(be);
			}
		}
		model.addAttribute("employeelist", bankemployeelist);
		return "Adminwork";
		}
		else
		{
			model.addAttribute("message","no employee");
			return "sampleadminhome";
		}
	}

	@GetMapping("/activate")
	public String employeeActivation(@RequestParam("userid") String user, Model model) {
		BankEmployee bankemployee = employeedao.findByUserId(user);
		bankemployee.setStatus("activate");
		BankEmployee be = employeedao.save(bankemployee);
		String status = be.getStatus();
		if (be != null && status.equals("activate")) {
			model.addAttribute("message", user + "sucesfully activate");
			return "sampleadminhome";
		} else {
			model.addAttribute("message", user + "not activated");
			return "sampleadminhome";
		}
	}

	
	
	@GetMapping("/autocustlist")
	public String autoDefaulters(Model model,HttpSession session) 
	{
		session.setAttribute("sortdefault","autosort");
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) {
			if (customer.getBorrowerRating() >= 8
					&& (customer.getAccuralStatus() == 2 || customer.getAccuralStatus() == 3
							|| customer.getAccuralStatus() == 4 || customer.getAccuralStatus() == 5)) {
				cl.add(customer);
			}
		}
		model.addAttribute("customerList", cl);
		return "Adminworkofcustomer";
	}

	@GetMapping("/manualcustlist")
	public String manualDefaulters(Model model,HttpSession session) 
	{
		session.setAttribute("sortdefault","manualsort");
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) {
			int due = customer.getDues() * 30;
			if (due >= 90 && (customer.getBorrowerRating() == 5 || customer.getBorrowerRating() == 6
					|| customer.getBorrowerRating() == 7 || customer.getAccuralStatus() == 1
					|| customer.getAccuralStatus() == 6 || customer.getAccuralStatus() == 7)) {
				cl.add(customer);
			}
		}
		model.addAttribute("customerList", cl);
		return "Adminworkofcustomer";
	}

	@GetMapping("/activationList")
	public String autoWaver(Model model,HttpSession session) 
	{
		session.setAttribute("sortdefault","awrs");
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) 
		{
			if(customer.getCard().getCardStatus().equals("Re-active"))
			{
				cl.add(customer);
			}
		}
		model.addAttribute("customerList", cl);
		return "Adminworkofcustomer";
	}
	
	
	@GetMapping("/DefList")
	public String validators(Model model,HttpSession session) 
	{
		session.setAttribute("sortdefault","valid");
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) 
		{
			if(customer.getStatus().equals("defaulter"))
			{
				cl.add(customer);
			}
		}
		model.addAttribute("customerList", cl);
		return "Adminworkofcustomer";
	}
	
	@GetMapping("/list")
	public String getAllList(Model model,HttpSession session) {
		session.setAttribute("sortdefault","alllist");
		List<LoanCustomer> custlist = adminservices.customerlist();
		model.addAttribute("customerList", custlist);
		return "Adminworkofcustomer";
	}

	@GetMapping("/sixmonthlist")
	public String sixMonth(Model model,HttpSession session) 
	{
		session.setAttribute("sortdefault", "sixlist");
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) {
			if (customer.getDues() >= 6) {
				cl.add(customer);
			}
		}
		model.addAttribute("custList", cl);
		return "Adminworkofcustomer";
	}


	@GetMapping("/ativates")
	public String activateCards(Model model) {
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<Card> cl = new ArrayList<Card>();
		for (LoanCustomer loancustomer : custlist) {

			if (loancustomer.getCard().getCardStatus().equals("Re-active")) {
				cl.add(loancustomer.getCard());

			}
		}
		System.out.println(cl);
		model.addAttribute("card", cl);
		return "reactivates";
	}

	@GetMapping("/verifycard")
	public String verifyActivationCards(@RequestParam("id") int res, Model model) 
	{
		Date d=new Date();
		LoanCustomer lc = loandao.findByaccountNumber(res);
		if (lc.getCard() != null) {
			lc.getCard().setCardStatus("active");
			lc.getCard().setExpDate(d);
			LoanCustomer loan = loandao.save(lc);
			if (loan != null) {
				model.addAttribute("message", lc.getCustomerName() + "card activated successfully and message is sent to customer");
				return "sampleadminhome";
			} else {
				model.addAttribute("message", lc.getCustomerName() + "card not activated");
				return "sampleadminhome";
			}
		}
		model.addAttribute("message", lc.getCustomerName() + "card doesnot exits");
		return "sampledminhome";
	}

	@GetMapping("/decCard")
	public String deactivateCard(@RequestParam("id") int res, Model model) 
	{
		Date d=new Date();
		LoanCustomer lc = loandao.findByaccountNumber(res);
		if (lc.getCard() != null) {
			lc.getCard().setCardStatus("deactive");
			lc.getCard().setExpDate(d);
			LoanCustomer loan = loandao.save(lc);
			if (loan != null) {
				model.addAttribute("message", lc.getCustomerName() + "card deactivated successfully");
				return "sampleadminhome";
			} else {
				model.addAttribute("message", lc.getCustomerName() + "card not deactivated");
				return "sampleadminhome";
			}
		}
		model.addAttribute("message", lc.getCustomerName() + "card doesnot exits");
		return "sampledminhome";
	}

	@GetMapping("/genRep")
	public String customerReport(Model model) {
		int autocount = 0;
		int manualcount = 0;
		int count = 0;
		int validcount = 0;
		List<LoanCustomer> custlist = adminservices.customerlist();
		for (LoanCustomer customer : custlist) {
			int due = customer.getDues() * 30;
			if (customer.getStatus().equals("defaulter")) 
			{
				count++;
				if (customer.getBorrowerRating() >= 8
						&& (customer.getAccuralStatus() == 2 || customer.getAccuralStatus() == 3
								|| customer.getAccuralStatus() == 4 || customer.getAccuralStatus() == 5)) {
					autocount++;

				}

				else if (due >= 90 && (customer.getBorrowerRating() == 5 || customer.getBorrowerRating() == 6
						|| customer.getBorrowerRating() == 7 || customer.getAccuralStatus() == 1
						|| customer.getAccuralStatus() == 6 || customer.getAccuralStatus() == 7)) {
					manualcount++;
				}
			} 
		 if (customer.getCard().getCardStatus().equals("Re-active")) 
			{

				validcount++;
			}

		}
		model.addAttribute("auto", autocount);
		model.addAttribute("manual", manualcount);
		
		model.addAttribute("calul", count);
		model.addAttribute("req", validcount);
		return "report";
	}

	@GetMapping("/validcus")
	public String reportAuto(Model model) {
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer loancustomer : custlist) {
			if (loancustomer.getStatus().equals("validate")) {
				cl.add(loancustomer);
			}
		}
		model.addAttribute("customerList", cl);
		return "Adminworkofcustomer";
	}

	@GetMapping("/validwaver")
	public String reportWaver(Model model) {
		List<LoanCustomer> custlist = adminservices.customerlist();
		List<LoanCustomer> cl = new ArrayList<LoanCustomer>();
		for (LoanCustomer loancustomer : custlist) {
			if (loancustomer.getStatus().equals("autowaver")) {
				cl.add(loancustomer);
			}
		}
		model.addAttribute("customerList", cl);
		return "Adminworkofcustomer";
	}

	@PostMapping("/sort")
	public String autoSort(@RequestParam("number") String res, @RequestParam("order") String odd, Model model,
			HttpSession session) 
	{
		String sd=(String)session.getAttribute("sortdefault");
		List<LoanCustomer> dcl = new ArrayList<LoanCustomer>();
		if(sd.equals("autosort"))
		{
		List<LoanCustomer> custlist = adminservices.customerlist();
		Sorting s = new Sorting();
		List<LoanCustomer> cl1 = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) {
			if (customer.getBorrowerRating() >= 8
					&& (customer.getAccuralStatus() == 2 || customer.getAccuralStatus() == 3
							|| customer.getAccuralStatus() == 4 || customer.getAccuralStatus() == 5)) {
				cl1.add(customer);
			}
		}
		if (res.equals("dues")) {
			if (odd.equals("ass")) {
				dcl = s.dueAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.dueDesSort(cl1);
			}
		} else if (res.equals("accountNumber")) {
			if (odd.equals("ass")) {
				dcl = s.accAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.accDesSort(cl1);
			}
		}
		}
		
		if(sd.equals("manualsort"))
		{
		List<LoanCustomer> custlist = adminservices.customerlist();
		Sorting s = new Sorting();
		List<LoanCustomer> cl1 = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) {
			int due = customer.getDues() * 30;
			if (due >= 90 && (customer.getBorrowerRating() == 5 || customer.getBorrowerRating() == 6
					|| customer.getBorrowerRating() == 7 || customer.getAccuralStatus() == 1
					|| customer.getAccuralStatus() == 6 || customer.getAccuralStatus() == 7)) {
				cl1.add(customer);
			}
		}
		if (res.equals("dues")) {
			if (odd.equals("ass")) {
				dcl = s.dueAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.dueDesSort(cl1);
			}
		} else if (res.equals("accountNumber")) {
			if (odd.equals("ass")) {
				dcl = s.accAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.accDesSort(cl1);
			}
		}
		}
		
		
		if(sd.equals("awrs"))
		{
		List<LoanCustomer> custlist = adminservices.customerlist();
		Sorting s = new Sorting();
		List<LoanCustomer> cl1 = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) 
		{
			if(customer.getCard().getCardStatus().equals("Re-active"))
			{
				cl1.add(customer);
			}
		}
		if (res.equals("dues")) {
			if (odd.equals("ass")) {
				dcl = s.dueAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.dueDesSort(cl1);
			}
		} else if (res.equals("accountNumber")) {
			if (odd.equals("ass")) {
				dcl = s.accAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.accDesSort(cl1);
			}
		}
		}
		
		
		

		if(sd.equals("valid"))
		{
		List<LoanCustomer> custlist = adminservices.customerlist();
		Sorting s = new Sorting();
		List<LoanCustomer> cl1 = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) 
		{
			if(customer.getStatus().equals("defaulter"))
			{
				cl1.add(customer);
			}
		}
		if (res.equals("dues")) {
			if (odd.equals("ass")) {
				dcl = s.dueAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.dueDesSort(cl1);
			}
		} else if (res.equals("accountNumber")) {
			if (odd.equals("ass")) {
				dcl = s.accAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.accDesSort(cl1);
			}
		}
		}
		
		
		if(sd.equals("alllist"))
		{
		List<LoanCustomer> custlist = adminservices.customerlist();
		Sorting s = new Sorting();
		List<LoanCustomer> cl1 = new ArrayList<LoanCustomer>();
		if (res.equals("dues")) {
			if (odd.equals("ass")) {
				dcl = s.dueAssSort(custlist);
			} else if (odd.equals("des")) {
				dcl = s.dueDesSort(custlist);
			}
		} else if (res.equals("accountNumber")) {
			if (odd.equals("ass")) {
				dcl = s.accAssSort(custlist);
			} else if (odd.equals("des")) {
				dcl = s.accDesSort(custlist);
			}
		}
		}
		
	
		if(sd.equals("sixlist"))
		{
		List<LoanCustomer> custlist = adminservices.customerlist();
		Sorting s = new Sorting();
		List<LoanCustomer> cl1 = new ArrayList<LoanCustomer>();
		for (LoanCustomer customer : custlist) {
			if (customer.getDues() >= 6) {
				cl1.add(customer);
			}
		}
		if (res.equals("dues")) {
			if (odd.equals("ass")) {
				dcl = s.dueAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.dueDesSort(cl1);
			}
		} else if (res.equals("accountNumber")) {
			if (odd.equals("ass")) {
				dcl = s.accAssSort(cl1);
			} else if (odd.equals("des")) {
				dcl = s.accDesSort(cl1);
			}
		}
		}
		model.addAttribute("customerList", dcl);
		return "Adminworkofcustomer";
		
		
	}
@GetMapping("/setvalidate")
	public String statusValidate(@RequestParam("id") int res,Model model)
	{
	LoanCustomer lc=loandao.findByaccountNumber(res);
	lc.setStatus("validate");
	lc.setAccuralStatus(9);
	lc.setBorrowerRating(1);
	LoanCustomer lc1=loandao.save(lc);
	if(lc1!=null)
	{
	    model.addAttribute("message",lc.getCustomerName()+" is now a validator");
		return "sampleadminhome";
	}
	else
	{
		 model.addAttribute("message",lc.getCustomerName()+" is not updated as validator");
			return "sampleadminhome";
	}
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


@GetMapping("/setautowaver")
public String statusAutoWaver(@RequestParam("id") int res,Model model)
{
LoanCustomer lc=loandao.findByaccountNumber(res);
lc.setStatus("autowaver");
lc.setAccuralStatus(8);
lc.setBorrowerRating(3);
LoanCustomer lc1=loandao.save(lc);
if(lc1!=null)
{
    model.addAttribute("message",lc.getCustomerName()+" is now a autowaver");
	return "sampleadminhome";
}
else
{
	 model.addAttribute("message",lc.getCustomerName()+" is not updated as autowaver");
		return "sampleadminhome";
}
}


@GetMapping("/setdefaulter")
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
	return "sampleadminhome";
}
else
{
	 model.addAttribute("message",lc.getCustomerName()+" is not updated as defaulter");
		return "sampleadminhome";
}
}


@GetMapping("/sendalert")
public String sendMessage(@RequestParam("id") int res,Model model)
{
LoanCustomer lc=loandao.findByaccountNumber(res);

	 model.addAttribute("message","message was sent to " +lc.getEmail());
		return "sampleadminhome";

}

	@GetMapping("/logout")
	public String logOut() {
		return "home";
	}
@PostMapping("/getAccount")
	public String searchAccountNumber(@RequestParam("num") int number,Model model)
	{
		LoanCustomer lc=loandao.findByaccountNumber(number);
		if(lc!=null)
		{
		model.addAttribute("cust", lc);
		return  "AdminSearch";
		}
		else
		{
			model.addAttribute("message","account number not found");
			return "sampleadminhome";
		}
		}
	}
	
	

