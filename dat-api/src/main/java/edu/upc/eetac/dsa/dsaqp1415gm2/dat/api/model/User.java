package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

public class User {
	private String name = "Anonymous";
	private String password;
	private boolean loginSuccessful;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getPassword() {
		return password;
		
	}

	public void setPassword(String password) {
		this.password = password;	
	}
	
	public boolean isLoginSuccessful() {
		return loginSuccessful;
	}
 
	public void setLoginSuccessful(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
	}
}
