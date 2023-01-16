package com.restaurantOrder.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

import com.restaurantOrder.Order;

import org.junit.jupiter.api.Test;

class Tests {
	
	private final Order order1 = new Order();

	@Test
	void doesOrderNumberGenerate() {
		int orderNumber = order1.getOrderNumber();
		Assert.assertNotEquals(0, orderNumber);
	}

}
