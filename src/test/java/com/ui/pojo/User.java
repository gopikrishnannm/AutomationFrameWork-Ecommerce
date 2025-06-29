package com.ui.pojo;

public class User {
	
	
	
	private String emailAddress;
	private String password;
	
	
	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	public String getEmailAdress() {
		return emailAddress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAddress = emailAdress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailAdress=" + emailAddress + ", password=" + password + "]";
	}
	
	

}
