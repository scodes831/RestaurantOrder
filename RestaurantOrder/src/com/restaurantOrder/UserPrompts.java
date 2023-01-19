package com.restaurantOrder;

import java.math.BigDecimal;
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
		int selection;
		do {
			System.out.println("Please select an item (press 0 when finished):\n1 - Pizzas\n2 - Burgers\n3 - Salads");
			selection = in.nextInt();
			if (selection == 1) {
				Pizza pizza = new Pizza();
				order.getOrderItems().add(pizza);
				pizza.showPizzaOptions(pizza, in);
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
		} while ((selectionError) || (selection != 0));
	}

	public static void askForTip(Order order, Scanner in) throws Exception {
		int selection;
		boolean selectionError = false;

		do {
			System.out.println("Your subtotal is $" + order.getOrderSubTotal()
					+ ". Would you like to leave a tip?\n1 - 15%\n2 - 18%\n3 - 20%\n4 - No Tip");
			selection = in.nextInt();
			if (selection == 1) {
				order.calculateOrderTip(order,  new BigDecimal(.15));
			} else if (selection == 2) {
				order.calculateOrderTip(order,  new BigDecimal(.18));
			} else if (selection == 3) {
				order.calculateOrderTip(order,  new BigDecimal(.2));
			} else if (selection == 4) {
				order.calculateOrderTip(order,  new BigDecimal(0));
			} else {
				selectionError = true;
				throw new Exception("Please choose a valid selection.");
			}

		} while (selectionError);
		
		System.out.println("You have added a tip of " + order.getOrderTip() + ".");

	}

	public static void askToViewReceipt(Order order, Scanner in) throws Exception {
		int selection;
		boolean selectionError = false;
		
		do {
			System.out.println("Would you like to view your receipt?\n1 - Yes\n2 - No");
			selection = in.nextInt();
			if (selection == 1) {
				System.out.println("Printing your receipt...");
				order.showOrderReceipt(order);
			} else if (selection == 2) {
				System.out.println("Ok, thank you for your order #" + order.getOrderNumber() + ". Have a great day!");
			} else {
				selectionError = true;
				throw new Exception("Please choose a valid selection.");
			}
			
		} while (selectionError);
	}

}
