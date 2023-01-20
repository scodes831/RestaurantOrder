package com.restaurantOrder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {

	private int orderNumber;
	private LocalDate orderDate;
	private LocalTime orderTime;
	private String orderedBy;
	private String orderType;
	private ArrayList<MenuItem> orderItems = new ArrayList<MenuItem>();

	private BigDecimal orderSubTotal;
	private BigDecimal orderTip;
	private BigDecimal orderTotal;
	
	public Order () {
		this.orderNumber = generateOrderNumber();
		this.orderDate = LocalDate.now();
		this.orderTime = LocalTime.now();
	}

	private int generateOrderNumber() {
		int[] numArr = new int[9];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int) (Math.random() * 10);
		}
		StringBuilder str = new StringBuilder();
		for (int i : numArr) {
			str.append(i);
		}
		
		int orderNumber = Integer.parseInt(str.toString());
		return orderNumber;
	}
	
	public void calculateOrderSubTotal(Order order) {
		BigDecimal price = new BigDecimal(0);
		
		for (MenuItem item : order.getOrderItems()) {
			price = price.add(item.getPrice());
		}
		
		BigDecimal roundedPrice = price.setScale(2, RoundingMode.HALF_UP);
		order.setOrderSubTotal(roundedPrice);
	}
	
	public void calculateOrderTip(Order order, BigDecimal tipPercentage) {
		BigDecimal tipAmount = order.getOrderSubTotal().multiply(tipPercentage);
		BigDecimal roundedTipAmount = tipAmount.setScale(2, RoundingMode.HALF_UP);
		order.setOrderTip(roundedTipAmount);
	}
	
	public void calculateOrderTotal(Order order) {
		BigDecimal orderTotal = order.getOrderSubTotal().add(order.getOrderTip());
		BigDecimal roundedOrderTotal = orderTotal.setScale(2, RoundingMode.HALF_UP);
		order.setOrderTotal(roundedOrderTotal);
	}
	
	public void showOrderReceipt(Order order) {
		System.out.println("\n===========================================\n");
		
		System.out.println("Order Number: " + order.getOrderNumber());
		System.out.println("Order Date: " + order.getOrderDate());
		System.out.println("Order Time: " + order.getOrderTime());
		System.out.println("\nOrder Type: " + order.getOrderType());
		
		System.out.println("\nItems Ordered: " + order.getOrderItems().size());
		
		for (MenuItem item : order.getOrderItems()) {
			System.out.println("\n" + item.getDescription() + " $" + item.getPrice());
		}
		
		System.out.println("\nSubtotal: $" + order.getOrderSubTotal());
		System.out.println("Tip Amount: $" + order.getOrderTip());
		System.out.println("\nOrder Total: $" + order.getOrderTotal());
		System.out.println("\n===========================================\n");
		
	}

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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	

}
