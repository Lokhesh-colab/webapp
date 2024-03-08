package com.lokhesh.app.loginrequest;

public class LoginRequest {

	private String username;
	private String password;
	private String staffusername;
	private String staffpassword;
	
	
	public String getStaffusername() {
		return staffusername;
	}
	public void setStaffusername(String staffusername) {
		this.staffusername = staffusername;
	}
	public String getStaffpassword() {
		return staffpassword;
	}
	public void setStaffpassword(String staffpassword) {
		this.staffpassword = staffpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRequest(String username, String password, String staffusername, String staffpassword) {
		super();
		this.username = username;
		this.password = password;
		this.staffusername = staffusername;
		this.staffpassword = staffpassword;
	}
	public LoginRequest() {
		super();
	}
}
