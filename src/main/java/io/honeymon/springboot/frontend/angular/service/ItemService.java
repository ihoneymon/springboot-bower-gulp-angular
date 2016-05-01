package io.honeymon.springboot.frontend.angular.service;

import java.util.List;

import io.honeymon.springboot.frontend.angular.entity.Item;

/**
 * {@link Item} Service
 * 
 * @author honeymon
 *
 */
public interface ItemService {

	/**
	 * create or update {@link Item}
	 * 
	 * @param item
	 * @return
	 */
	Item save(Item item);

	/**
	 * Delete {@link Item}
	 * 
	 * @param item
	 */
	void delete(Item item);

	/**
	 * Get {@link Item}
	 * 
	 * @return
	 */
	List<Item> findAll();
}
