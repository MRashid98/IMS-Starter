package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String itemName;
	private float price;
	private int quantity;

	public Item(Long id, String itemName, float price, int quantity) {
		this.setId(id);
		this.setItemName(itemName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public Item(String itemName, float price, int quantity) {
		this.setItemName(itemName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() == null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

}
