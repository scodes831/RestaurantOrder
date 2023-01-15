package com.restaurantOrder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
	
	private int orderNumber;
	private LocalDate orderDate;
	private LocalTime orderTime;
	private String orderedBy;
	private ArrayList<MenuItem> orderItems;
	
	private BigDecimal orderSubTotal;
	private BigDecimal orderTip;
	private BigDecimal orderTotal;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderedBy() {
		return orderedBy;
	}
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}
	public BigDecimal getOrderSubTotal() {
		return orderSubTotal;
	}
	public void setOrderSubTotal(BigDecimal orderSubTotal) {
		this.orderSubTotal = orderSubTotal;
	}
	public BigDecimal getOrderTip() {
		return orderTip;
	}
	public void setOrderTip(BigDecimal orderTip) {
		this.orderTip = orderTip;
	}
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}
	public ArrayList<MenuItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(ArrayList<MenuItem> orderItems) {
		this.orderItems = orderItems;
	}

}
