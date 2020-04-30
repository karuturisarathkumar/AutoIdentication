package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.AdminLogin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.Issues;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
import com.Auto_Identication.Auto.Identication.Models.Security;

public interface AdminServices 
{
public int storeAdmin(Admin admin);
public int getAdmin(AdminLogin adminlogin);
public List<BankEmployee> emplist();
public List<Issues> findAll();
public List<LoanCustomer> customerlist();
public Security getSecurity(String contactNumber);
public Security getSecuritypwd(String userId);
public boolean updatePassword(Admin admin);
public Admin getuserdata(String userId);
}
