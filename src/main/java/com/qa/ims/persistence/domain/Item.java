package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String itemName;
	private Float price;
	private Integer quantity;

	public Item(Long id, String itemName, Float price, Integer quantity) {
		this.setId(id);
		this.setItemName(itemName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public Item(String itemName, Float price, Integer quantity) {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "id=" + id + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
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

		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.id))
			return false;

		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.price))
			return false;

		if (getQuantity() == null) {
			if (other.getQuantity() != null)
				return false;
		} else if (!getQuantity().equals(other.quantity))
			return false;
		return true;
	}

}
