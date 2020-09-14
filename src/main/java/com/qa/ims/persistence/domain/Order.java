package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customerId;
	private Long itemId;

	public Order(Long id, Long customerId, Long itemId) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setItemId(itemId);
	}

	public Order(Long customerId, Long itemId) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "id:" + id + ", customerId:" + customerId + ", itemId:" + itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());

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

		Order other = (Order) obj;
		if (getId() == null) {
			if (other.getId() == null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;

		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.customerId))
			return false;

		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.itemId))
			return false;

		return true;
	}

}
