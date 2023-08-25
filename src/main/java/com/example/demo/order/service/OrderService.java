package com.example.demo.order.service;

import org.springframework.data.domain.Page;

import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;

public interface OrderService {
	
	Page<OrdersDTO> getList(int page);//주문페이지
	
	int register(OrdersDTO dto);//주문등록
	
	OrdersDTO read(int orderNumber);//주문상세조회
	
	void modify(OrdersDTO dto);//주문수정
	
	void remove(OrdersDTO dto);//주문삭제
	
	
	//DTOtoEntity 변환
	default Orders dtoToEntity(OrdersDTO dto) {
		Member member = Member.builder().id(dto.getId()).build();
		Item item = Item.builder().itemNo(dto.getItemNo()).build();
		
		Orders entity = Orders.builder()
				.orderNo(dto.getItemNo())
				.itemNo(item)
				.id(member)
				.receiverName(dto.getReceiverName())
				.receiverPhone(dto.getReceiverPhone())
				.shipAddress(dto.getShipAddress())
				.build();
		
		return entity;	
	}
	
	//EntityToDto 변환
	default OrdersDTO entityToDto(Orders entity) {
		OrdersDTO dto = OrdersDTO.builder()
				.orderNumber(entity.getOrderNo())
				.itemNo(entity.getItemNo().getItemNo())
				.id(entity.getId().getId())
				.orderDate(entity.getRegDate())
				.receiverName(entity.getReceiverName())
				.receiverPhone(entity.getReceiverPhone())
				.shipAddress(entity.getShipAddress())
				.build();
		
		return dto;
	}
	

}
