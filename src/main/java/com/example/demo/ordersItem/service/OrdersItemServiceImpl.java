package com.example.demo.ordersItem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.ordersItem.dto.OrdersItemDTO;
import com.example.demo.ordersItem.entity.OrdersItem;
import com.example.demo.ordersItem.repository.OrdersItemRepository;

@Service
public class OrdersItemServiceImpl implements OrdersItemService{

	@Autowired
	OrdersItemRepository repository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<OrdersItemDTO> getList(int orderNo) {
		Optional<Orders> result = orderRepository.findById(orderNo);
		Orders orders = result.get();
		List<OrdersItem> entityList = repository.getOrdersItemByOrders(orders);
		List<OrdersItemDTO> dtoList = new ArrayList<>();
		
		for(OrdersItem o : entityList) {
			OrdersItemDTO dto = entityToDTO(o);
			dtoList.add(dto);
		}
		return dtoList;
	}

}
