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
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the Customer Id");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the Item Id");
		Long itemId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId, itemId));
		LOGGER.info("Order Created");
		return order;
	}

	@Override
	public Order update() {
		Order order = null;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to EDIT and order or ADD an item to an existing order?");
		String opt = scanner.nextLine();

		if (opt.equalsIgnoreCase("edit")) {
			editOrder();
		} else if (opt.equalsIgnoreCase("add")) {
			addItem();
		}
		return order;
	}

	public Order addItem() {
		LOGGER.info("Please enter the id of the Customer");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the id of the Item");
		Long itemId = utils.getLong();

		Order order = orderDAO.addItem(new Order(customerId, itemId));
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
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
