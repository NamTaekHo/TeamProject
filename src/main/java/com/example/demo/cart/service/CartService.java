package com.example.demo.cart.service;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;

public interface CartService {
	
	int register(CartDTO dto);
	
	CartDTO read(int cartNo);
	
	void modify(CartDTO dto);
	
	void remove(CartDTO dto);
	
	
	//DtoToEntity 변환
	
	default Cart dtoToEntity(CartDTO dto) {
		Member member = Member.builder().id(dto.getId()).build();
		Item item = Item.builder().itemNo(dto.getItemNo()).build();
		
		Cart entity = Cart.builder()
				.cartNo(dto.getCartNo())
				.itemNo(item)
				.id(member)
				.count(dto.getCount())
				.build();
		
		return entity;
	}
	
	//entityToDto 변환
	default CartDTO entityToDto(Cart entity) {
		CartDTO dto = CartDTO.builder()
				.cartNo(entity.getCartNo())
				.itemNo(entity.getItemNo().getItemNo())
				.id(entity.getId().getId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.count(entity.getCount())
				.build();
		
		return dto;
	}

}
