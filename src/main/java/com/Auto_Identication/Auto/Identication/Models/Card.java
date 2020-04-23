package com.Auto_Identication.Auto.Identication.Models;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "card")
public class Card 
{
	@Id
	@Generated("assigned")
private int cardNumber;
	@Column(name="accno", unique = true , nullable = false)
private int accountNumber;
	@Column(name="name")
private String customerName;
	@Column(name="date")
private Date expDate;
	@Column(name="status")
private String cardStatus;
	@Column(name="reason")
private String reActivationReason;
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getReActivationReason() {
		return reActivationReason;
	}
	public void setReActivationReason(String reActivationReason) {
		this.reActivationReason = reActivationReason;
	}
	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", accountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", expDate=" + expDate + ", cardStatus=" + cardStatus + ", reActivationReason=" + reActivationReason
				+ "]";
	}
	
	
	
	
	
	
	
}
