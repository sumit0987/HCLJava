package com.demo.fundtransferapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String name;
	private String gender;
	private int age;
	private String panno;
	private Long aadharno;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public Long getAadharno() {
		return aadharno;
	}
	public void setAadharno(Long aadharno) {
		this.aadharno = aadharno;
	}

	
	public Customer() {
		
	}
	public Customer(int userid, String name, String gender, int age, String panno, Long aadharno) {
		super();
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.panno = panno;
		this.aadharno = aadharno;
	}
	
	
	
}
