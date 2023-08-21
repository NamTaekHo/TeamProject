package com.example.demo.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
