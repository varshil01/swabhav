package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers {
	@Id
	@Column(name = "cust_id")
	private String cust_id;

	@Column(name = "address")
	private String address;

	@Column(name = "cust_name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "passsword")
	private String password;

	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	private Set<Cart> cart = new HashSet<Cart>();

	public Customers() {

	}

	public Customers(String cust_id, String address, String name,
			String username, String password) {
		super();
		this.cust_id = cust_id;
		this.address = address;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
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

}
