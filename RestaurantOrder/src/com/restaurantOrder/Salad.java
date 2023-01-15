package com.restaurantOrder;

public class Salad extends MenuItem {
	
	private String flavor;
	private String dressing;
	
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getDressing() {
		return dressing;
	}
	public void setDressing(String dressing) {
		this.dressing = dressing;
	}
}
