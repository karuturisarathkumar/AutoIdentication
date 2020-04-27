package com.Auto_Identication.Auto.Identication.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.Security;
@Repository
public interface EmployeeDao extends JpaRepository<BankEmployee, String> 
{
public List<BankEmployee> findAll();
public BankEmployee findByUserId(String userId);
@Query("select s from Security s where s.contactNumber=:cnumber ")
public Security getSecurityCredentials(@Param("cnumber")String contactNumber);
@Query("select s from Security s where s.userId=:uid ")
public Security getSecuritypassword(@Param("uid")String userId);
@Query("select s from BankEmployee s where s.userId=:uid ")
public BankEmployee getEmployee(@Param("uid")String userId);
}
