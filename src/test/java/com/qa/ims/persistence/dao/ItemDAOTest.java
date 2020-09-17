package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(2L, "Phone Case", 4.99F);
		final Item noPrice = new Item(3L, "PS5", null);
		assertEquals(created, DAO.create(created));
		assertEquals(null, DAO.create(noPrice));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Phone", 499.99F));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(1L, "Phone", 499.99F), DAO.readLatest());
	}

	@Test
	public void testReadItem() {
		final Long ID = 1L;
		assertEquals(new Item(ID, "Phone", 499.99F), DAO.readItem(ID));
	}

	@Test
	public void testUpdate() throws Exception {
		final Item updated = new Item(1L, "OnePlus 8t", 799.99F);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
		assertEquals(0, DAO.delete(3));
	}

}
