package com.restaurantOrder;

import java.util.ArrayList;
import java.util.Scanner;

public class Salad extends MenuItem {

	private ArrayList<String> toppings = new ArrayList<String>();
	private String dressing;

	public void showSaladOptions(Salad salad, Scanner in) throws Exception {
		chooseSaladToppings(salad, in);
		chooseSaladDressing(salad, in);
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
		System.out.println("Select salad toppings (press 0 when finished):\n1 - Tomatoes\n2 - Onions\n3 - Bell Peppers\n4 - Olives\n5 - Cucumbers"
				+ "\n6 - Carrots\n7 - Mushrooms\n8 - Feta Cheese (+$1)\n9 - Cheddar Cheese (+$1)");
		int selection = in.nextInt();
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
		} else {
			throw new Exception("Please enter a valid selection.");
		}
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

	
}
