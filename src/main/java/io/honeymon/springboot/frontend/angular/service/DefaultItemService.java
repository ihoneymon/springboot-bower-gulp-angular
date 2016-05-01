package io.honeymon.springboot.frontend.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.honeymon.springboot.frontend.angular.entity.Item;
import io.honeymon.springboot.frontend.angular.repository.ItemRepository;

@Service
@Transactional(readOnly = true)
public class DefaultItemService implements ItemService {

	private ItemRepository repository;

	@Autowired
	public void setRepository(ItemRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Item save(Item item) {
		return repository.save(item);
	}

	@Override
	@Transactional
	public void delete(Item item) {
		repository.delete(item);
	}

	@Override
	public List<Item> findAll() {
		return repository.findAll();
	}

}
