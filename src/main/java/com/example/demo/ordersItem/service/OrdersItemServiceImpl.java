package com.example.demo.ordersItem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ordersItem.dto.OrdersItemDTO;
import com.example.demo.ordersItem.entity.OrdersItem;
import com.example.demo.ordersItem.repository.OrdersItemRepository;

@Service
public class OrdersItemServiceImpl implements OrdersItemService{

	@Autowired
	OrdersItemRepository repository;
	
	@Override
	public List<OrdersItemDTO> getList(int orderNo) {
		List<OrdersItem> entityList = repository.getOrdersItemByOrders(orderNo);
		List<OrdersItemDTO> dtoList = new ArrayList<>();
		
		for(OrdersItem o : entityList) {
			OrdersItemDTO dto = entityToDTO(o);
			dtoList.add(dto);
		}
		return dtoList;
	}

}
