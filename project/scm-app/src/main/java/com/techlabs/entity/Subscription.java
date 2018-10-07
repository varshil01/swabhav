package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subscription")
public class Subscription {

	@Id
	@Column(name = "sub_id")
	private String sub_id;

	@Column(name = "type")
	private String type;

	@Column(name = "no_of_user")
	private int no_of_user;

	@Column(name="status")
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "sub_module", joinColumns = { @JoinColumn(name = "sub_id") }, inverseJoinColumns = { @JoinColumn(name = "module_id") })
	private Set<Module> modules = new HashSet<Module>();

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "sub_service", joinColumns = { @JoinColumn(name = "sub_id") }, inverseJoinColumns = { @JoinColumn(name = "service_id") })
	private Set<Service> services = new HashSet<Service>();

	@ManyToOne
	@JoinColumn(name = "tenant_id")
	private Tenant tenant;

	public Subscription() {

	}

	public Subscription(String sub_id, String type, int no_of_user,String status,Tenant tenant) {
		super();
		this.sub_id = sub_id;
		this.type = type;
		this.no_of_user = no_of_user;
		this.status=status;
		this.tenant=tenant;
	}

	public String getSub_id() {
		return sub_id;
	}

	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNo_of_user() {
		return no_of_user;
	}

	public void setNo_of_user(int no_of_user) {
		this.no_of_user = no_of_user;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	

}
