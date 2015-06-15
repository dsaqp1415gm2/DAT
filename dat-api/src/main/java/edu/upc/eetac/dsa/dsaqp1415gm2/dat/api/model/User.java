package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

public class User {
	private String username;
	private String userpass;
	private boolean loginSuccessful;
	
	public boolean isLoginSuccessful() {
		return loginSuccessful;
	}
 
	public void setLoginSuccessful(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
}
