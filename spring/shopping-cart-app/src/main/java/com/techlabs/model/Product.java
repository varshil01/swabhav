package com.techlabs.model;

public class Product {

	private String id;
	private String name;
	private double cost;
	private int discount;

	public Product() {

	}

	public Product(String id, String name, double cost, int discount) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
