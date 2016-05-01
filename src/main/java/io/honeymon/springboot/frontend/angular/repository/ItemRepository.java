package io.honeymon.springboot.frontend.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.honeymon.springboot.frontend.angular.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
