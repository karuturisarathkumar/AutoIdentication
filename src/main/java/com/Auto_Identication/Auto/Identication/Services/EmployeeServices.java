package com.Auto_Identication.Auto.Identication.Services;

import java.util.List;

import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.BankEmployeeLogin;

public interface EmployeeServices
{
public int storeEmployee(BankEmployee bankemployee);
public int getBankEmployee(BankEmployeeLogin bankemployeelogin);
public List<BankEmployee> employeeList();
}
