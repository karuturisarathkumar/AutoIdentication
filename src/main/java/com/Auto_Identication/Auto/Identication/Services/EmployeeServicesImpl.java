package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Auto_Identication.Auto.Identication.Dao.EmployeeDao;
import com.Auto_Identication.Auto.Identication.Dao.LoanCustomerDao;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.BankEmployeeLogin;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
@Service
@Component
public class EmployeeServicesImpl implements EmployeeServices 
{
	@Autowired
private EmployeeDao employeedao;
	@Autowired
	private LoanCustomerDao loandao;
	@Override
	public int storeEmployee(BankEmployee bankemployee)
	{
		BankEmployee be=employeedao.findByUserId(bankemployee.getUserId());
		if(be==null)
		{
			BankEmployee emp=employeedao.save(bankemployee);
			if(emp!=null)
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
	public List<BankEmployee> employeeList() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int getBankEmployee(BankEmployeeLogin bankemployeelogin) 
	{
		BankEmployee be=employeedao.findByUserId(bankemployeelogin.getUserId());
		if(be!=null)
		{
			if(be.getPassword().equals(bankemployeelogin.getPassword()))
			{
				if(be.getStatus().equals("activate"))
				{
				return 1;
				}
				else
				{
					return 2;
				}
			}
			else
			{
				return 3;
			}
		}
		return 0;
	}



	@Override
	public List<LoanCustomer> customerlist() 
	{
		List<LoanCustomer> lc=loandao.findAll();
		return lc;
	}

}
