package com.example.demo.item.service;

import java.util.List;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.entity.Item;

public interface ItemService {
	
	int register(ItemDTO dto);
	
	List<ItemDTO> getList();
	
	ItemDTO read(int no);
	
	void modify(ItemDTO dto);
	
	void remove(int no);
	
	default Item dtoToEntity(ItemDTO dto) {
		Item entity = Item.builder()
				.itmeNo(dto.getItemNo())
				.itemName(dto.getItemName())
				.price(dto.getPrice())
				.image(dto.getImage())
				.description(dto.getDescription())
				.build();
		return entity;
	}
	
	default ItemDTO entityToDto(Item entity) {
		ItemDTO dto = ItemDTO.builder()
				.itemNo(entity.getItmeNo())
				.itemName(entity.getItemName())
				.price(entity.getPrice())
				.image(entity.getImage())
				.description(entity.getDescription())
				.build();
		return dto;
		
	}

}
