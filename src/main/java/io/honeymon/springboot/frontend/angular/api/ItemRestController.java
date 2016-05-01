package io.honeymon.springboot.frontend.angular.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.honeymon.springboot.frontend.angular.entity.Item;
import io.honeymon.springboot.frontend.angular.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {

	ItemService service;

	@Autowired
	public void setService(ItemService service) {
		this.service = service;
	}

	@RequestMapping(method = GET)
	public ResponseEntity<List<Item>> getItems() {
		return ResponseEntity.ok(service.findAll());
	}

	@RequestMapping(method = POST)
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		service.save(item);

		return ResponseEntity
				.created(UriComponentsBuilder.fromUriString("/api/items/{item}").buildAndExpand(item.getId()).toUri())
				.body(item);
	}

	@RequestMapping(method = DELETE, value = "/{item}")
	public ResponseEntity<Void> deleteItem(@PathVariable Item item) {
		service.delete(item);
		return ResponseEntity.noContent().build();
	}
}
