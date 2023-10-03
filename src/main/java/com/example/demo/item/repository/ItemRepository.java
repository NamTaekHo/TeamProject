package com.example.demo.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	// select * from item where item.category = 'top';
	
	@Query("SELECT i FROM Item i WHERE i.category = :category ORDER BY i.regDate DESC")
	List<Item> getItemByCategory(@Param("category") String category);
	
}
