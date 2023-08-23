package com.example.demo.item.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.entity.Item;

public interface ItemService {
	
	int register(ItemDTO dto);
	
	List<ItemDTO> getList();
	
	ItemDTO read(int itemNo);
	
	void modify(ItemDTO dto);
	
	void remove(int itemNo);
	
	Page<ItemDTO> getList(int pageNumber);
	
	default Item dtoToEntity(ItemDTO dto) {
		Item entity = Item.builder()
				.itemNo(dto.getItemNo())
				.itemName(dto.getItemName())
				.price(dto.getPrice())
				.image(dto.getImage())
				.description(dto.getDescription())
				.build();
		return entity;
	}
	
	default ItemDTO entityToDto(Item entity) {
		ItemDTO dto = ItemDTO.builder()
				.itemNo(entity.getItemNo())
				.itemName(entity.getItemName())
				.price(entity.getPrice())
				.image(entity.getImage())
				.description(entity.getDescription())
				.build();
		return dto;
		
	}

	

}