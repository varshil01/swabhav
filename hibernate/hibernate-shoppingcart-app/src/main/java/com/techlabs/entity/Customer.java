package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {

	@Id
	private UUID cust_id;

	@Column(name = "cust_name")
	private String cust_name;

	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> order = new HashSet<Order>();

	public Customer(UUID cust_id, String cust_name, String address) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.address = address;
	}

	public UUID getCust_id() {
		return cust_id;
	}

	public void setCust_id(UUID cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

}