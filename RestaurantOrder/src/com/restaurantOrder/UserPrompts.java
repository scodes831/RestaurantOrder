package com.restaurantOrder;

import java.util.Scanner;

public class UserPrompts {

	public static void askOrderType(Order order) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please select the order type:\n1 - Dine In\n2 - Takeout");
		int selection = in.nextInt();
		if (selection == 1) {
			order.setOrderType("Dine In");
		} else {
			order.setOrderType("Takeout");
		}
		in.close();
	}
	
	public static void askOrderItems(Order order) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Please select an item:\n1 - Pizza.....$8\n2 - Burger....$10\n3 - Salad.....$7");
		int selection = in.nextInt();
		if (selection == 1) {
			Pizza pizza = new Pizza();
			pizza.showPizzaOptions(pizza);
		} else if (selection == 2) {
			Burger burger = new Burger();
			burger.showBurgerOptions(burger);
		} else if (selection == 3) {
			Salad salad = new Salad();
			salad.showSaladOptions(salad);
		} else {
			throw new Exception("Please choose a valid selection.");
		}
	}

}
