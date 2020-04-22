package com.Auto_Identication.Auto.Identication.Controllers;

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
import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
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
	model.addAttribute("employeelist", employeelist);
	return "Adminhome";
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



@GetMapping("/logout")
public String logOut()
{
	return "home";
}



	
	
	
	
	
}
