package com.example.demo.order.service;

import java.util.List;

import com.example.demo.member.entity.Member;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;

public interface OrdersService {

	//주문 등록
	int register(OrdersDTO dto);
	
	//주문 조회
	List<OrdersDTO> getList(int orderNo);
	
	//주문 삭제
	void remove(int orderNo);
	
	//DTOtoEntity
	default Orders dtoToEntity(OrdersDTO dto) {
		Member m = Member.builder().id(dto.getId()).build();
		
		Orders order = Orders.builder()
				.orderNo(dto.getOrderNo())
				.id(m)
				.receiverName(dto.getReceiverName())
				.receiverPhone(dto.getReceiverPhone())
				.shipAddress(dto.getShipAddress())
				.totalPrice(dto.getTotalPrice())
				.build();
		return order;
	}
	
	//EntityToDTO
	default OrdersDTO entityToDTO(Orders order) {
		OrdersDTO dto = OrdersDTO.builder()
				.orderNo(order.getOrderNo())
				.id(order.getId().getId())
				.receiverName(order.getReceiverName())
				.receiverPhone(order.getReceiverPhone())
				.shipAddress(order.getShipAddress())
				.totalPrice(order.getTotalPrice())
				.orderDate(order.getRegDate())
				.build();
		return dto;
	}
	
	
}
