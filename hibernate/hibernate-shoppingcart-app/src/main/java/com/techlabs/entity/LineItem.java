package com.techlabs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LineItem {
	
	@Id
	private int lineitem_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id",nullable=false)
	private Order order;
	
	
	@OneToOne(mappedBy="lineitem",cascade=CascadeType.ALL)
	private Product product;


	public LineItem(int lineitem_id, int quantity, Order order, Product product) {
		super();
		this.lineitem_id = lineitem_id;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
	}


	public int getLineitem_id() {
		return lineitem_id;
	}


	public void setLineitem_id(int lineitem_id) {
		this.lineitem_id = lineitem_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
}