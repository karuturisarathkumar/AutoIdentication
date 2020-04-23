package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;

public interface AdminServices 
{
public int storeAdmin(Admin admin);
public int getAdmin(AdminLogin adminlogin);
public List<BankEmployee> emplist();
public List<LoanCustomer> customerlist();
}
