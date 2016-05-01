package io.honeymon.springboot.frontend.angular.api;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.honeymon.springboot.frontend.angular.Application;
import io.honeymon.springboot.frontend.angular.entity.Item;
import io.honeymon.springboot.frontend.angular.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@Transactional
public class ItemRestControllerTest {

	@Autowired
	WebApplicationContext wac;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	ItemService service;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
				.alwaysExpect(handler().handlerType(ItemRestController.class)).alwaysDo(print()).alwaysDo(log())
				.build();
	}

	@Test
	public void testGetItems() throws Exception {
		// given

		// when
		mockMvc.perform(get("/api/items"));

		// then
	}

	@Test
	public void testPostItem() throws Exception {
		// given
		Item item = new Item("Test title", "test");

		// when
		ResultActions result = mockMvc.perform(post("/api/items").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(item)));

		// then
		result.andExpect(status().isCreated());
	}

	@Test
	public void testDeleteItem() throws Exception {
		// given
		Item item = new Item("Test title", "test");
		service.save(item);

		// when
		ResultActions result = mockMvc
				.perform(delete("/api/items/{item}", item.getId()).contentType(MediaType.APPLICATION_JSON_UTF8));

		// then
		result.andExpect(status().isNoContent());
	}
}
