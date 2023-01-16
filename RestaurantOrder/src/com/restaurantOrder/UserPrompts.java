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
	}

}
