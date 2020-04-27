package com.Auto_Identication.Auto.Identication.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Auto_Identication.Auto.Identication.Models.LoanCustomer;
@Repository
public interface LoanCustomerDao extends JpaRepository<LoanCustomer, Integer> 
{
public LoanCustomer findByaccountNumber(int accno);
public List<LoanCustomer> findAll();

}
