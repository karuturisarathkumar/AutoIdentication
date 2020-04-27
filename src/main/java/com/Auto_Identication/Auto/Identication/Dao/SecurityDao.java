package com.Auto_Identication.Auto.Identication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Auto_Identication.Auto.Identication.Models.BankEmployee;
import com.Auto_Identication.Auto.Identication.Models.Security;

public interface SecurityDao extends JpaRepository<Security, String> {
	
	public Security findByUserId(String userId);

}
