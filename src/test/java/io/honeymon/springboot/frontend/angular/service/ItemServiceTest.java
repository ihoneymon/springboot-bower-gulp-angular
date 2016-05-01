package io.honeymon.springboot.frontend.angular.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import io.honeymon.springboot.frontend.angular.Application;
import io.honeymon.springboot.frontend.angular.entity.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@Transactional
public class ItemServiceTest {

	@Autowired
	public ItemService service;

	@Test
	public void testCreateItem() throws Exception {
		// given
		String title = "Test item";
		String type = "test";
		Item item = new Item(title, type);

		// when
		Item saveItem = service.save(item);

		// then
		assertThat(saveItem.getId(), is(notNullValue()));
		assertThat(saveItem.getTitle(), is(title));
		assertThat(saveItem.getType(), is(type));
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test(expected = DataIntegrityViolationException.class)
	public void testCreateItem_title이_빈값인경우_예외발생() throws Exception {
		String title = null;
		String type = "test";
		Item item = new Item(title, type);

		// when
		service.save(item);

		// then
		fail();
	}

	@Test
	public void testGetItems() throws Exception {
		// given
		String title = "Test item";
		String type = "test";
		Item item = new Item(title, type);
		service.save(item);

		// when
		List<Item> items = service.findAll();

		// then
		assertThat(items.contains(item), is(true));
	}
	
	@Test
	public void testDeleteItem() throws Exception {
		// given
		String title = "Test item";
		String type = "test";
		Item item = new Item(title, type);
		service.save(item);
		
		// when
		service.delete(item);

		// then
		List<Item> items = service.findAll();
		assertThat(items.isEmpty(), is(true));
	}
}
