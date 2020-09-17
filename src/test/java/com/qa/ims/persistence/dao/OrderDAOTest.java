package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

	}

	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void create() {
		final Long orderId = 2L;
		final Long customerId = 1L;

		final Order created = new Order(orderId, customerId);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testAddItem() {
		final Long orderId = 1L;
		final long itemId = 1L;

		final Order newItem = new Order(orderId, itemId);
		assertEquals(newItem, DAO.addItem(newItem));
	}

	@Test
	public void testReadAll() {
		final Long orderId = 1L;
		final Long customerId = 3L;
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(orderId, customerId));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		final Long orderId = 1L;
		final Long customerId = 3L;
		assertEquals(new Order(orderId, customerId), DAO.readLatest());
	}

	@Test
	public void testReadOrder() {
		final Long orderId = 1L;
		final Long customerId = 3L;
		assertEquals(new Order(orderId, customerId), DAO.readOrder(orderId));
	}

	@Test
	public void testReadOrderItem() {
		final String expected = "ID: 1; Order ID: 1; Item ID: 1 ";
		DAO.readOrderItem();
		assertEquals(expected.trim(), outContent.toString().trim());
	}

	@Test
	public void testUpdate() {
		final Long orderId = 1L;
		final Long customerId = 1L;
		final Order updated = new Order(orderId, customerId);

		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.deleteItem(1));
	}

	@Test
	public void testCalculateSum() {
		final Float expected = 499.99F;

		assertEquals(expected, DAO.sumOrder(1L));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

}
