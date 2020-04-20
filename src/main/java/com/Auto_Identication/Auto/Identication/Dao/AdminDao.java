package com.Auto_Identication.Auto.Identication.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Auto_Identication.Auto.Identication.Models.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, String>
{
public List<Admin> findAll();
public Admin findByuserId(String userid);
}
