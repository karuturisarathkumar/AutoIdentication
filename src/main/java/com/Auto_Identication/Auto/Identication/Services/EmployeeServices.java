package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.BankEmployeeLogin;
import com.Auto_Identication.Auto.Identication.Models.Issues;
import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
import com.Auto_Identication.Auto.Identication.Models.Security;

public interface EmployeeServices
{
public int storeEmployee(BankEmployee bankemployee);
public int getBankEmployee(BankEmployeeLogin bankemployeelogin);
public List<BankEmployee> employeeList();
public List<Issues> findAll();
public List<LoanCustomer> customerlist();
public Security getSecurity(String contactNumber);
public Security getSecuritypwd(String userId);
public boolean updatePassword(BankEmployee bankEmployee);
public BankEmployee getuserdata(String userId);



}
