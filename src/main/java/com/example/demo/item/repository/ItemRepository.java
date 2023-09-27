package com.example.demo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	// select * from item where item.category = 'top';
	
	@Query("select i from Item i where i.category = :category")
	List<Item> getItemByCategory(@Param ("category") String category);
}
