package com.example.demo.ordersItem.service;

import java.util.List;

import com.example.demo.item.entity.Item;
import com.example.demo.order.entity.Orders;
import com.example.demo.ordersItem.dto.OrdersItemDTO;
import com.example.demo.ordersItem.entity.OrdersItem;

public interface OrdersItemService {
	
	// 주문번호로 주문상품 목록 찾기
	List<OrdersItemDTO> getList(int orderNo);

	//DTOtoEntity
		default OrdersItem dtoToEntity(OrdersItemDTO dto) {
			Item i = Item.builder().itemNo(dto.getINo()).build();
			Orders o = Orders.builder().orderNo(dto.getONo()).build();
			
			OrdersItem oi = OrdersItem.builder()
					.no(dto.getNo())
					.iNo(i)
					.oNo(o)
					.price(dto.getPrice())
					.count(dto.getCount())
					.build();
			return oi;
		}
		
		//EntityToDTO
		default OrdersItemDTO entityToDTO(OrdersItem ordersItem) {
			
			OrdersItemDTO dto = OrdersItemDTO.builder()
					.no(ordersItem.getNo())
					.iNo(ordersItem.getINo().getItemNo())
					.oNo(ordersItem.getONo().getOrderNo())
					.price(ordersItem.getPrice())
					.count(ordersItem.getCount())
					.regDate(ordersItem.getRegDate())
					.modDate(ordersItem.getModDate())
					.build();
			return dto;
		}
	
}
