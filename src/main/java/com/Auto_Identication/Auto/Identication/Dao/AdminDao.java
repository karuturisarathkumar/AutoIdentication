package com.Auto_Identication.Auto.Identication.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Auto_Identication.Auto.Identication.Models.Admin;
import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.Security;
@Repository
public interface AdminDao extends JpaRepository<Admin, String>
{
public List<Admin> findAll();
public Admin findByuserId(String userid);
@Query("select s from Security s where s.contactNumber=:cnumber ")
public Security getSecurityCredentials(@Param("cnumber")String contactNumber);
@Query("select s from Security s where s.userId=:uid ")
public Security getSecuritypassword(@Param("uid")String userId);
@Query("select s from Admin s where s.userId=:uid ")
public Admin getAdmin(@Param("uid")String userId);
}
