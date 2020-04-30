package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Auto_Identication.Auto.Identication.Dao.AdminDao;
import com.Auto_Identication.Auto.Identication.Dao.EmployeeDao;
import com.Auto_Identication.Auto.Identication.Dao.IssuesDao;
import com.Auto_Identication.Auto.Identication.Dao.LoanCustomerDao;
import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.Issues;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
import com.Auto_Identication.Auto.Identication.Models.Security;
@Component
@Service
public class AdminServicesimpl implements AdminServices 
{
	@Autowired
private AdminDao admindao;
	@Autowired
private EmployeeDao employeedao;
	@Autowired
	private LoanCustomerDao loandao;
	@Autowired
	private IssuesDao issuedao;
	@Override
	public int storeAdmin(Admin admin) 
	{
		Admin ad=admindao.findByuserId(admin.getUserId());
		if(ad==null)
		{
			Admin a=admindao.save(admin);
			if(a!=null)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		return 2;
	}

	@Override
	public int getAdmin(AdminLogin adminlogin)
	{
		Admin ad=admindao.findByuserId(adminlogin.getUserId());
		if(ad!=null)
		{
			if(ad.getPassword().equals(adminlogin.getPassword()))
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		return 2;
	}

	@Override
	public List<BankEmployee> emplist() 
	{
		List<BankEmployee> belist=employeedao.findAll();
		
		return belist;
	}

	@Override
	public List<LoanCustomer> customerlist() 
	{
		List<LoanCustomer> cl=loandao.findAll();
		return cl;
	}

	@Override
	public Security getSecurity(String contactNumber) {
		return admindao.getSecurityCredentials(contactNumber);
	}

	@Override
	public Security getSecuritypwd(String userId) {
		return admindao.getSecuritypassword(userId);
	}

	@Override
	public boolean updatePassword(Admin admin) {
		
		Admin ad = admindao.save(admin);
		
		if(ad!=null) {
			
			return true;
		}
		else {
			return false;
		}
	
	}

	@Override
	public Admin getuserdata(String userId) {
		return admindao.getAdmin(userId);
	}

	@Override
	public List<Issues> findAll() {
		// TODO Auto-generated method stub
		return issuedao.findAll();
	}

	
	

}
