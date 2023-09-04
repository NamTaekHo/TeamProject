package com.example.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrderRepository orderRepository;
	
	//주문상품데이터베이스 autowired필요

	@Override
	public int register(OrdersDTO dto) {
		Orders order = dtoToEntity(dto);
		orderRepository.save(order);
		return dto.getOrderNo();
	}

	@Override
	public List<OrdersDTO> getList(int orderNo) {
//		List<Orders> list = orderRepository.
		
		return null;
	}

	@Override
	public void remove(int orderNo) {
		// TODO Auto-generated method stub
		
	}

}
