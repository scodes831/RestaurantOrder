package com.restaurantOrder;

import java.util.ArrayList;

public class Burger extends MenuItem {

	private String cookingPreference;
	private ArrayList<String> toppings;
	private boolean hasBun;

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

	public boolean isHasBun() {
		return hasBun;
	}

	public void setHasBun(boolean hasBun) {
		this.hasBun = hasBun;
	}

}
