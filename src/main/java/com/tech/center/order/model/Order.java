package com.tech.center.order.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private String orderName;
	private int budget;
	private Date duration;
	private String category;
	private String details;
	
	public Order() {}
	
	public Order(String orderName, int budget, String category, String details) {
		this.orderName = orderName;
		this.budget = budget;
		this.category = category;
		this.details = details;
	}
	
	public Order(String orderName, int budget, Date duration , String category, String details) {
		this.orderName = orderName;
		this.budget = budget;
		this.duration = duration;
		this.category = category;
		this.details = details;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return orderName + "  -  " + budget + "$" + " (" + category + ")";
	}
}
