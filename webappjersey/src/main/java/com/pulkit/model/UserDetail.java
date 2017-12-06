package com.pulkit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="userTable")
@XmlRootElement
public class UserDetail implements Serializable {


	private static final long serialVersionUID = 3377725516475656270L;
	
	@Id
	private int id;
	private String name;
	private String address;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}
	
	

}
