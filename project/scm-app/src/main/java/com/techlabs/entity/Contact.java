package com.techlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="contact_no")
	private long contact_no;
	
	@Column(name="email")
	private String email_id;
	
	@ManyToOne
	@JoinColumn(name="tenant_id")
	private Tenant tenant;

	public Contact(){
		
	}
	public Contact(int id, String fname, String lname, long contact_no,
			String email_id, Tenant tenant) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.tenant = tenant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	
	
}
