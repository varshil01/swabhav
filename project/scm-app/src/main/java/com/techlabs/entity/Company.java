package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Company")
public class Company {

	@Id
	@Column(name="cmp_id")
	private long cmp_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Module> module=new HashSet<Module>();
	
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Service> services=new HashSet<Service>();
	
	public Company(){
		
	}

	public Company(long cmp_id, String username, String password) {
		super();
		this.cmp_id = cmp_id;
		this.username = username;
		this.password = password;
	}

	public long getCmp_id() {
		return cmp_id;
	}

	public void setCmp_id(long cmp_id) {
		this.cmp_id = cmp_id;
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


	public Set<Module> getModule() {
		return module;
	}

	public void setModule(Set<Module> module) {
		this.module = module;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
	
	
}
