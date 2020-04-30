package com.Auto_Identication.Auto.Identication.Dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Auto_Identication.Auto.Identication.Models.Issues;
@Repository
public interface IssuesDao extends JpaRepository<Issues,Integer>{
	//@Override
	//public List<Issues> findAll();
	
	

	

}
