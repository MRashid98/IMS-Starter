package com.qa.ims.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = null;
		LOGGER.info("Would you like to view ALL the orders or view the SUM of a particular order?");
		String opt = utils.getString();

		if (opt.equalsIgnoreCase("all")) {
			orders = orderDAO.readAll();
			for (Order order : orders) {
				LOGGER.info(order.toString());
			}
			return orders;
		} else if (opt.equalsIgnoreCase("sum")) {
			readOrderSum();
		}
		return orders;
	}

	public Float readOrderSum() {
		Float sum;
		LOGGER.info("Please enter the ID of the order");
		Long orderId = utils.getLong();
		sum = orderDAO.sumOrder(orderId);
		return sum;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the Customer Id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));

		LOGGER.info("Would you like to add items to current order? (YES/NO)");
		String opt = utils.getString();

		if (opt.equalsIgnoreCase("yes")) {
			addItem();
		}

		LOGGER.info("Order Created");
		return order;
	}

	@Override
	public Order update() {
		Order order = null;

		LOGGER.info("Would you like to EDIT and order or ADD an item to an existing order?");
		String opt = utils.getString();
		if (opt.equalsIgnoreCase("edit")) {
			editOrder();
		} else if (opt.equalsIgnoreCase("add")) {
			addItem();
		}
		return order;
	}

	public Order addItem() {
		LOGGER.info("Please enter the id of the Order");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the id of the Item you want to add");
		long itemId = utils.getLong();

		Order order = orderDAO.addItem(new Order(orderId, itemId));
		LOGGER.info("Item Added");
		return order;
	}

	public Order editOrder() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the id of the Customer");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the id of the Item");
		Long itemId = utils.getLong();

		Order order = orderDAO.update(new Order(id, customerId, itemId));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public int delete() {

		LOGGER.info("Would you like to remove the entire order (ALL) or remove a specific item (ITEM)");
		String opt = utils.getString();
		if (opt.equalsIgnoreCase("all")) {
			deleteOrder();
		} else if (opt.equalsIgnoreCase("item")) {
			deleteItem();
		}

		return 0;
	}

	public int deleteOrder() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

	public int deleteItem() {
		orderDAO.readOrderItem();
		LOGGER.info("From the list above select the id you want to remove");
		Long id = utils.getLong();
		return orderDAO.deleteItem(id);
	}

}
