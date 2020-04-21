package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Auto_Identication.Auto.Identication.Dao.AdminDao;
import com.Auto_Identication.Auto.Identication.Dao.EmployeeDao;
import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
@Component
@Service
public class AdminServicesimpl implements AdminServices 
{
	@Autowired
private AdminDao admindao;
	@Autowired
private EmployeeDao employeedao;
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

}
