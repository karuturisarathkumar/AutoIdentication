package com.Auto_Identication.Auto.Identication.Models;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "issues")
public class Issues {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int id;
	@Column
	private String userId;
	@Column
	private String role;
	@Column
	private String issue;
	@Column
	private String description;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Issues [userId=" + userId + ", role=" + role + ", issue=" + issue + ", description=" + description
				+ "]";
	}



	
	
}
