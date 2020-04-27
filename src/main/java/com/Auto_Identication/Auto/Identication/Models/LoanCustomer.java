package com.Auto_Identication.Auto.Identication.Models;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="loancustomer")
public class LoanCustomer implements Comparable<LoanCustomer>
{
	@Id
	@Generated("assigned")
	@Column(name="accno")
private int accountNumber;
	@Column(name="accname")
private String customerName;
	@Column(name="money")
private double borrowedAmount;
	@Column
private int tenure;
	@Column
	private int moneyPaid;
	@Column
	private double fine;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column(name="paid")
private Date lastPaid;
	@Column
private int dues;
	@Column(name = "acstatus")
	private int accuralStatus;
	@Column(name= "rating")
	private int borrowerRating;
	@Column
	private String status;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cno",referencedColumnName = "cardNumber")
private Card card;
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
	public double getBorrowedAmount() {
		return borrowedAmount;
	}
	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getMoneyPaid() {
		return moneyPaid;
	}
	public void setMoneyPaid(int moneyPaid) {
		this.moneyPaid = moneyPaid;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getLastPaid() {
		return lastPaid;
	}
	public void setLastPaid(Date lastPaid) {
		this.lastPaid = lastPaid;
	}
	public int getDues() {
		return dues;
	}
	public void setDues(int dues) {
		this.dues = dues;
	}
	public int getAccuralStatus() {
		return accuralStatus;
	}
	public void setAccuralStatus(int accuralStatus) {
		this.accuralStatus = accuralStatus;
	}
	public int getBorrowerRating() {
		return borrowerRating;
	}
	public void setBorrowerRating(int borrowerRating) {
		this.borrowerRating = borrowerRating;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "LoanCustomer [accountNumber=" + accountNumber + ", customerName=" + customerName + ", borrowedAmount="
				+ borrowedAmount + ", tenure=" + tenure + ", moneyPaid=" + moneyPaid + ", fine=" + fine + ", email="
				+ email + ", mobile=" + mobile + ", lastPaid=" + lastPaid + ", dues=" + dues + ", accuralStatus="
				+ accuralStatus + ", borrowerRating=" + borrowerRating + ", status=" + status + ", card=" + card + "]";
	}
	@Override
	public int compareTo(LoanCustomer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	









}
