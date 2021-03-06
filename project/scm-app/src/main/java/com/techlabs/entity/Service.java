package com.techlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Service")
public class Service {

	@Id
	@Column(name="service_id")
	private long service_id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cmp_id")
	private Company company;
	
	public Service(){
		
	}
	

	
	public Service(long service_id, String name, Company company) {
		super();
		this.service_id = service_id;
		this.name = name;
		this.company = company;
	}



	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public long getService_id() {
		return service_id;
	}

	public void setService_id(long service_id) {
		this.service_id = service_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
}
