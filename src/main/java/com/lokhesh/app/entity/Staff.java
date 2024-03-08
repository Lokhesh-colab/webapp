package com.lokhesh.app.entity;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String staffusername;
	private String staffpassword;
	private String role;
	private BigInteger mobile;
	
	

	public Staff(Long id, String staffusername, String staffpassword, String role, BigInteger mobile) {
		super();
		this.id = id;
		this.staffusername = staffusername;
		this.staffpassword = staffpassword;
		this.role = role;
		this.mobile = mobile;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



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



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public BigInteger getMobile() {
		return mobile;
	}



	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}



	public Staff() {
		super();
	}
	
}
