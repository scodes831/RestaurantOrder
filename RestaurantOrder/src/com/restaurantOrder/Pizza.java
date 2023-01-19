package com.restaurantOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza extends MenuItem {

	private final BigDecimal BASE_PRICE = new BigDecimal(5);
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
		int selection;
		do {
			System.out.println(
					"Select toppings: (press 0 when finished)\n1 - Cheese\n2 - Pepperoni (+$2)\n3 - Sausage (+$2)\n4 - Chicken (+$2)\n5 - Bell Peppers"
							+ "\n6 - Olives\n7 - Extra Cheese (+$1)");
			selection = in.nextInt();
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
			} else if (selection == 0 && pizza.getToppings().size() == 0) {
				System.out.println("You must add at least 1 topping.");
			} else if (selection == 0) {
				System.out.println("Toppings have been added.");
			} else {
				throw new Exception("Please enter a valid selection.");
			}
		} while ((selection != 0) || (pizza.getToppings().size() < 1));

		confirmPizza(pizza);
	}

	public void confirmPizza(Pizza pizza) {
		StringBuilder toppingsStr = new StringBuilder();

		for (int i = 0; i < pizza.getToppings().size(); i++) {
			toppingsStr.append(pizza.getToppings().get(i).toLowerCase());

			if (pizza.getToppings().size() == 1) {
				continue;
			} else if (pizza.getToppings().size() == 2 && i == 0) {
				toppingsStr.append(" and ");
			} else if (pizza.getToppings().size() == 2 && i == 1) {
				continue;
			} else if (i == pizza.getToppings().size() - 2) {
				toppingsStr.append(", and ");
			} else if (i != pizza.getToppings().size() - 1) {
				toppingsStr.append(", ");
			}
		}

		String desc = new String(pizza.getSize().toLowerCase() + " " + pizza.getCrust().toLowerCase()
				+ " crust pizza with " + toppingsStr.toString());

		pizza.setDescription(desc);
		pizza.calculatePizzaPrice(pizza);
		System.out.println("You have added " + desc + " to your order. Price: $" + pizza.getPrice());

	}

	public void calculatePizzaPrice(Pizza pizza) {

		BigDecimal price = getBASE_PRICE();

		if (pizza.getSize().equals("Medium")) {
			System.out.println("medium pizza +2");
			price = price.add(new BigDecimal(2));
		} else if (pizza.getSize().equals("Large")) {
			System.out.println("large pizza +5");
			price = price.add(new BigDecimal(5));
		}

		for (String topping : pizza.getToppings()) {
			if (topping.equals("Pepperoni")) {
				price = price.add(new BigDecimal(2));
			} else if (topping.equals("Sausage")) {
				price = price.add(new BigDecimal(2));
			} else if (topping.equals("Chicken")) {
				price = price.add(new BigDecimal(2));
			} else if (topping.equals("Extra Cheese")) {
				price = price.add(new BigDecimal(1));
			}
		}
		pizza.setPrice(price);

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

	public BigDecimal getBASE_PRICE() {
		return BASE_PRICE;
	}

}
