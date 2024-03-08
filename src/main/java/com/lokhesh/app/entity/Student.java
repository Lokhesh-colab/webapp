package com.lokhesh.app.entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"regno"})})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	@Column(name="regno")
	private BigInteger regno;
	
	private String address;
	private BigInteger mobileno;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public BigInteger getRegno() {
		return regno;
	}
	public void setRegno(BigInteger regno) {
		this.regno = regno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigInteger getMobileno() {
		return mobileno;
	}
	public void setMobileno(BigInteger mobileno) {
		this.mobileno = mobileno;
	}
	public Student(Long id, String username, String password, String firstname, String lastname, BigInteger regno,
			String address, BigInteger mobileno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.regno = regno;
		this.address = address;
		this.mobileno = mobileno;
	}
	public Student() {
		super();
	}
	public void setId(String string) {
		// TODO Auto-generated method stub
		
	}
}
