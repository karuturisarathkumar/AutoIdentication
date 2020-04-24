package com.Auto_Identication.Auto.Identication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Auto_Identication.Auto.Identication.Models.Security;
@Repository
public interface SecurityDao extends JpaRepository<Security,Integer>
{
public Security findByuserId(String userid);

}
