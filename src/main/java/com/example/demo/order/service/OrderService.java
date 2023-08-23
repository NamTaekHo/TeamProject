package com.example.demo.order.service;

import org.springframework.data.domain.Page;

import com.example.demo.item.entity.Item;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;

public interface OrderService {
	
	Page<OrdersDTO> getlist(int pageNumber);
	
	boolean register(OrdersDTO dto);
	
	OrdersDTO read(int orderNumber);
	
	void modify(OrdersDTO orders);
	
	void delete(OrdersDTO orders);
	
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
