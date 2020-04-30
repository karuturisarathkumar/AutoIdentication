package com.Auto_Identication.Auto.Identication.Controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;

public class Sorting 
{
public List<LoanCustomer> dueAssSort(List<LoanCustomer> cus)
{
	List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
	Comparator<LoanCustomer> cmp=new Comparator<LoanCustomer>() 
	{

		@Override
		public int compare(LoanCustomer o1, LoanCustomer o2) 
		{
		if(o1.getDues()>o2.getDues())
		{
			return 1;
		}
		else if(o1.getDues()<o2.getDues())
		{
			return -1;
		}
		else
		{
			return 0;
		}
		}

	};
	cus.stream().sorted(cmp).forEach(t->cl.add(t));
	return cl;
}
public List<LoanCustomer> dueDesSort(List<LoanCustomer> cus)
{
	List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
	Comparator<LoanCustomer> cmp=new Comparator<LoanCustomer>() 
	{

		@Override
		public int compare(LoanCustomer o1, LoanCustomer o2) 
		{
		if(o1.getDues()>o2.getDues())
		{
			return -1;
		}
		else if(o1.getDues()<o2.getDues())
		{
			return 1;
		}
		else
		{
			return 0;
		}
		}

	};
	cus.stream().sorted(cmp).forEach(t->cl.add(t));
	return cl;
}
public List<LoanCustomer> accAssSort(List<LoanCustomer> cus)
{
	List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
	Comparator<LoanCustomer> cmp=new Comparator<LoanCustomer>() 
	{

		@Override
		public int compare(LoanCustomer o1, LoanCustomer o2) 
		{
		if(o1.getAccountNumber()>o2.getAccountNumber())
		{
			return 1;
		}
		else if(o1.getAccountNumber()>o2.getAccountNumber())
		{
			return -1;
		}
		else
		{
			return 0;
		}
		}

	};
	cus.stream().sorted(cmp).forEach(t->cl.add(t));
	return cl;
}
public List<LoanCustomer> accDesSort(List<LoanCustomer> cus)
{
	List<LoanCustomer> cl=new ArrayList<LoanCustomer>();
	Comparator<LoanCustomer> cmp=new Comparator<LoanCustomer>() 
	{

		@Override
		public int compare(LoanCustomer o1, LoanCustomer o2) 
		{
		if(o1.getAccountNumber()>o2.getAccountNumber())
		{
			return -1;
		}
		else if(o1.getAccountNumber()>o2.getAccountNumber())
		{
			return 1; 
		}
		else
		{
			return 0;
		}
		}

	};
	cus.stream().sorted(cmp).forEach(t->cl.add(t));
	return cl;
}
}
