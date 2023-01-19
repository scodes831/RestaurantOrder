package com.restaurantOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Salad extends MenuItem {

	private final BigDecimal BASE_PRICE = new BigDecimal(6);
	private ArrayList<String> toppings = new ArrayList<String>();
	private String dressing;

	public void showSaladOptions(Salad salad, Scanner in) throws Exception {
		chooseSaladDressing(salad, in);
		chooseSaladToppings(salad, in);
	}

	private void chooseSaladDressing(Salad salad, Scanner in) throws Exception {
		System.out.println("Select salad dressing:\n1 - Ranch\n2 - Caesar\n3 - Italian\n4 - None");
		int selection = in.nextInt();
		if (selection == 1) {
			salad.setDressing("Ranch");
		} else if (selection == 2) {
			salad.setDressing("Caesar");
		} else if (selection == 3) {
			salad.setDressing("Italian");
		} else if (selection == 4) {
			salad.setDressing("None");
		} else {
			throw new Exception("Please enter a valid selection.");
		}

	}

	private void chooseSaladToppings(Salad salad, Scanner in) throws Exception {
		int selection;

		do {
			System.out.println(
					"Select salad toppings (press 0 when finished):\n1 - Tomatoes\n2 - Onions\n3 - Bell Peppers\n4 - Olives\n5 - Cucumbers"
							+ "\n6 - Carrots\n7 - Mushrooms\n8 - Feta Cheese (+$1)\n9 - Cheddar Cheese (+$1)");
			selection = in.nextInt();
			if (selection == 1) {
				salad.getToppings().add("Tomatoes");
			} else if (selection == 2) {
				salad.getToppings().add("Onions");
			} else if (selection == 3) {
				salad.getToppings().add("Bell Peppers");
			} else if (selection == 4) {
				salad.getToppings().add("Olives");
			} else if (selection == 5) {
				salad.getToppings().add("Cucumbers");
			} else if (selection == 6) {
				salad.getToppings().add("Carrots");
			} else if (selection == 7) {
				salad.getToppings().add("Mushrooms");
			} else if (selection == 8) {
				salad.getToppings().add("Feta Cheese");
			} else if (selection == 9) {
				salad.getToppings().add("Cheddar Cheese");
			} else if (selection == 0) {
				System.out.println("Toppings have been added.");
			} else {
				throw new Exception("Please enter a valid selection.");
			}
		} while (selection != 0);
		confirmSalad(salad);
	}

	public void confirmSalad(Salad salad) {
		StringBuilder toppingsStr = new StringBuilder();

		if (salad.getToppings().size() == 0) {
			toppingsStr.append("Plain");
		} else {
			for (int i = 0; i < salad.getToppings().size(); i++) {
				toppingsStr.append(salad.getToppings().get(i).toLowerCase());

				if (salad.getToppings().size() == 1) {
					continue;
				} else if (salad.getToppings().size() == 2 && i == 0) {
					toppingsStr.append(" and ");
				} else if (salad.getToppings().size() == 2 && i == 1) {
					continue;
				} else if (i == salad.getToppings().size() - 2) {
					toppingsStr.append(", and ");
				} else if (i != salad.getToppings().size() - 1) {
					toppingsStr.append(", ");
				}
			}
		}

		String desc = new String(toppingsStr.toString().toLowerCase() + " salad with "
				+ salad.getDressing().toLowerCase() + " dressing.");
		
		salad.setDescription(desc);
		salad.calculateSaladPrice(salad);

		System.out.println("You have added a " + desc + ". Price: $" + salad.getPrice());
	}

	public void calculateSaladPrice(Salad salad) {

		BigDecimal price = getBASE_PRICE();

		for (String topping : salad.getToppings()) {
			if (topping.equals("Feta Cheese")) {
				price = price.add(new BigDecimal(1));
			} else if (topping.equals("Cheddar Cheese")) {
				price = price.add(new BigDecimal(1));
			}
		}

		salad.setPrice(price);

	}

	public String getDressing() {
		return dressing;
	}

	public void setDressing(String dressing) {
		this.dressing = dressing;
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
