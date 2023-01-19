package com.restaurantOrder.tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.restaurantOrder.Burger;
import com.restaurantOrder.MenuItem;
import com.restaurantOrder.Order;
import com.restaurantOrder.Pizza;
import com.restaurantOrder.Salad;

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
	
	@Test
	void doesFetaCheeseSaladCost7() {
		Salad salad1 = new Salad();
		salad1.getToppings().add("Feta Cheese");
		salad1.calculateSaladPrice(salad1);
		Assert.assertEquals(new BigDecimal(7), salad1.getPrice());		
	}
	
	@Test
	void doesCheddarCheeseSaladCost7() {
		Salad salad2 = new Salad();
		salad2.getToppings().add("Cheddar Cheese");
		salad2.calculateSaladPrice(salad2);
		Assert.assertEquals(new BigDecimal(7), salad2.getPrice());		
	}
	
	@Test
	void doesAmericanCheeseBurgerCost7() {
		Burger burger1 = new Burger();
		burger1.getToppings().add("Ketchup");
		burger1.getToppings().add("American Cheese");
		burger1.calculateBurgerPrice(burger1);
		Assert.assertEquals(new BigDecimal(7), burger1.getPrice());		
	}
	
	@Test
	void doesPlainBurgerCost6() {
		Burger burger2 = new Burger();
		burger2.calculateBurgerPrice(burger2);
		Assert.assertEquals(new BigDecimal(6), burger2.getPrice());		
	}
	
	@Test
	void doesOrderSubTotalEqual14() {
		Order order2 = new Order();
		Pizza pizza = new Pizza();
		order2.getOrderItems().add(pizza);
		pizza.setSize("Medium");
		pizza.getToppings().add("Cheese"); //$7
		pizza.calculatePizzaPrice(pizza);
		
		Burger burger = new Burger();
		order2.getOrderItems().add(burger);
		burger.getToppings().add("American Cheese"); //$7
		burger.calculateBurgerPrice(burger);
		
		order2.calculateOrderSubTotal(order2);
		Assert.assertEquals(new BigDecimal(14), order2.getOrderSubTotal());
		
	}
	
 }
