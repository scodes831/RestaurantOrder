package com.restaurantOrder;

import java.util.Scanner;

public class UserPrompts {

	public static void askOrderType(Order order, Scanner in) {
		System.out.println("Please select the order type:\n1 - Dine In\n2 - Takeout");
		int selection = in.nextInt();
		if (selection == 1) {
			order.setOrderType("Dine In");
		} else {
			order.setOrderType("Takeout");
		}
	}

	public static void askOrderItems(Order order, Scanner in) throws Exception {
		boolean selectionError = false;
		//need to bring user back to this menu after adding a menu item
		//add condition if user clicks 0 when there are no items in their order - you must add at least one item to your order
		do {
			System.out.println("Please select an item (press 0 when finished):\n1 - Pizzas\n2 - Burgers\n3 - Salads");
			int selection = in.nextInt();
			if (selection == 1) {
				Pizza pizza = new Pizza();
				pizza.showPizzaOptions(order, pizza, in);
			} else if (selection == 2) {
				Burger burger = new Burger();
				order.getOrderItems().add(burger);
				burger.showBurgerOptions(burger, in);
			} else if (selection == 3) {
				Salad salad = new Salad();
				order.getOrderItems().add(salad);
				salad.showSaladOptions(salad, in);
			} else if (selection == 0) {
				System.out.println("Items have been added.");
			} else {
				selectionError = true;
				throw new Exception("Please choose a valid selection.");
			}
		} while (selectionError);
	}

}
