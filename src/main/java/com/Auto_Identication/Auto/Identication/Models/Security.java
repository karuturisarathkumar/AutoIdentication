package com.Auto_Identication.Auto.Identication.Models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Security 
{
	@Id
	@Generated("assgined")
	private int id;
	@Column
private String userId;
	@Column
private String question;
	@Column
private String answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Security [id=" + id + ", userId=" + userId + ", question=" + question + ", answer=" + answer + "]";
	}

}
