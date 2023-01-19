package com.restaurantOrder.tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.restaurantOrder.Order;
import com.restaurantOrder.Pizza;

class Tests {
	
	@Test
	void doesOrderNumberGenerate() {
		Order order = new Order();
		int orderNumber = order.getOrderNumber();
		Assert.assertNotEquals(0, orderNumber);
	}
	
	@Test
	void doesSmallCheesePizzaCost5() {
		Pizza pizza1 = new Pizza();
		pizza1.setSize("Small");
		pizza1.getToppings().add("Cheese");
		pizza1.calculatePizzaPrice(pizza1);
		System.out.println(pizza1.getPrice());
		Assert.assertEquals(new BigDecimal(5), pizza1.getPrice());
	}
	
	@Test
	void doesMediumSausageChickenPizzaCost11() {
		Pizza pizza2 = new Pizza();
		pizza2.setSize("Medium");
		pizza2.getToppings().add("Sausage");
		pizza2.getToppings().add("Chicken");
		pizza2.calculatePizzaPrice(pizza2);
		Assert.assertEquals(new BigDecimal(11), pizza2.getPrice());
	}
	
	@Test
	void doesLargePepperoniExtraCheesePizzaCost13() {
		Pizza pizza3 = new Pizza();
		pizza3.setSize("Large");
		pizza3.getToppings().add("Pepperoni");
		pizza3.getToppings().add("Extra Cheese");
		pizza3.calculatePizzaPrice(pizza3);
		Assert.assertEquals(new BigDecimal(13), pizza3.getPrice());
	}
 }
