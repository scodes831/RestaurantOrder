package com.restaurantOrder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the restaurant! Please follow the prompts to place your order.");
		Scanner in = new Scanner(System.in);
		Order order = new Order();
		UserPrompts.askOrderType(order, in);
		UserPrompts.askOrderItems(order, in);

	}

}
