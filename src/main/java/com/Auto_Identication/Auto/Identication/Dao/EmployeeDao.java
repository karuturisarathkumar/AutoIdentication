package com.Auto_Identication.Auto.Identication.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
@Repository
public interface EmployeeDao extends JpaRepository<BankEmployee, String> 
{
public List<BankEmployee> findAll();
public BankEmployee findByUserId(String userId);
}
