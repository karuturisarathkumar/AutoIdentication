package com.Auto_Identication.Auto.Identication.Models;


import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "issues")
public class Issues {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cardNumber;
	
	@Column
	private String issues;
	@Column
	private String description;
	public Issues() {
		super();
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Issues [cardNumber=" + cardNumber + ", issues=" + issues + ", description=" + description + "]";
	}

}
