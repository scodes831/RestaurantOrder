package com.restaurantOrder;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizza extends MenuItem {

	private String size;
	private ArrayList<String> toppings = new ArrayList<String>();
	private String crust;

	public void showPizzaOptions(Pizza pizza, Scanner in) throws Exception {
		choosePizzaSize(pizza, in);
		choosePizzaCrust(pizza, in);
		choosePizzaToppings(pizza, in);
	}

	private void choosePizzaSize(Pizza pizza, Scanner in) throws Exception {
		System.out.println("Select pizza size:\n1 - Small.....$5\n2 - Medium....$7\n3 - Large.....$10");
		int selection = in.nextInt();
		if (selection == 1) {
			pizza.setSize("Small");
		} else if (selection == 2) {
			pizza.setSize("Medium");
		} else if (selection == 3) {
			pizza.setSize("Large");
		} else {
			throw new Exception("Please enter a valid selection.");
		}

	}

	private void choosePizzaCrust(Pizza pizza, Scanner in) throws Exception {
		System.out.println("Select type of crust:\n1 - Thin\n2 - Deep Dish");
		int selection = in.nextInt();
		if (selection == 1) {
			pizza.setCrust("Thin");
		} else if (selection == 2) {
			pizza.setCrust("Deep Dish");
		} else {
			throw new Exception("Please enter a valid selection.");
		}
	}

	private void choosePizzaToppings(Pizza pizza, Scanner in) throws Exception {
		
		System.out.println(
				"Select toppings: (press 0 when finished)\n1 - Cheese\n2 - Pepperoni (+$2)\n3 - Sausage (+$2)\n4 - Chicken (+$2)\n5 - Bell Peppers"
						+ "\n6 - Olives\n7 - Extra Cheese (+$1)");
		int selection = in.nextInt();
		if (selection == 1) {
			pizza.getToppings().add("Cheese");
		} else if (selection == 2) {
			pizza.getToppings().add("Pepperoni");
		} else if (selection == 3) {
			pizza.getToppings().add("Sausage");
		} else if (selection == 4) {
			pizza.getToppings().add("Chicken");
		} else if (selection == 5) {
			pizza.getToppings().add("Bell Peppers");
		} else if (selection == 6) {
			pizza.getToppings().add("Olives");
		} else if (selection == 7) {
			pizza.getToppings().add("Extra Cheese");
		} else {
			throw new Exception("Please enter a valid selection.");
		}

	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public ArrayList<String> getToppings() {
		return toppings;
	}

	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}

}
