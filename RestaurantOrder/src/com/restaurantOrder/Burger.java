package com.restaurantOrder;

import java.util.ArrayList;
import java.util.Scanner;

public class Burger extends MenuItem {

	private String cookingPreference;
	private ArrayList<String> toppings = new ArrayList<String>();
	private String bunType;
	
	public void showBurgerOptions(Burger burger, Scanner in) throws Exception {
		chooseCookingPreference(burger, in);
		chooseBun(burger, in);
		chooseToppings(burger, in);	
	}

	private void chooseToppings(Burger burger, Scanner in) throws Exception {
		System.out.println("Select burger toppings (press 0 when finished):\n1 - Ketchup\n2 - Mustard\n3 - Mayo\n4 - American Cheese\n5 - Swiss Cheese"
				+ "\n6 - Onion\n7 - Pickles\n8 - Tomato");
		int selection = in.nextInt();
		if (selection == 1) {
			burger.getToppings().add("Ketchup");
		} else if (selection == 2) {
			burger.getToppings().add("Mustard");
		} else if (selection == 3) {
			burger.getToppings().add("Mayo");
		} else if (selection == 4) {
			burger.getToppings().add("American Cheese");
		} else if (selection == 5) {
			burger.getToppings().add("Swiss Cheese");
		} else if (selection == 6) {
			burger.getToppings().add("Onion");
		} else if (selection == 7) {
			burger.getToppings().add("Pickles");
		} else if (selection == 8) {
			burger.getToppings().add("Tomato");
		} else {
			throw new Exception("Please enter a valid selection.");
		} 
	}

	private void chooseBun(Burger burger, Scanner in) throws Exception {
		System.out.println("Select bun type:\n1 - Brioche\n2 - Wheat\n3 - Lettuce\n4 - None");
		int selection = in.nextInt();
		if (selection == 1) {
			burger.setBunType("Brioche");
		} else if (selection == 2) {
			burger.setBunType("Wheat");
		} else if (selection == 3) {
			burger.setBunType("Lettuce");
		} else if (selection == 4) {
			burger.setBunType("None");
		} else {
			throw new Exception("Please enter a valid selection.");
		}
		
	}

	private void chooseCookingPreference(Burger burger, Scanner in) throws Exception {
		System.out.println("Select cooking preference:\n1 - Pink\n2 - No Pink");
		int selection = in.nextInt();
		if (selection == 1) {
			burger.setCookingPreference("Pink");
		} else if (selection == 2) {
			burger.setCookingPreference("No Pink");
		} else {
			throw new Exception("Please enter a valid selection.");
		}
	}

	public String getCookingPreference() {
		return cookingPreference;
	}

	public void setCookingPreference(String cookingPreference) {
		this.cookingPreference = cookingPreference;
	}

	public ArrayList<String> getToppings() {
		return toppings;
	}

	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}

	public String getBunType() {
		return bunType;
	}

	public void setBunType(String bunType) {
		this.bunType = bunType;
	}

	

}
