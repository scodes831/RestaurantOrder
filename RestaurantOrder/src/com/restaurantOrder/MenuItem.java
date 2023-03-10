package com.restaurantOrder;

import java.math.BigDecimal;

public abstract class MenuItem {

	private BigDecimal price;
	private String description;
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
