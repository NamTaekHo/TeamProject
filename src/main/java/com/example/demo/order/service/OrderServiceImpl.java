package com.example.demo.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public Page<OrdersDTO> getList(int page) {
		int pageNum = (page == 0) ? 0 : page - 1;
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("orderNo"));
		Page<Orders> entityPage = repository.findAll(pageable);
		Page<OrdersDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));

		return dtoPage;
	}

	@Override
	public int register(OrdersDTO dto) {// 컨트롤러에서 전달받은 dto를 엔티티로 변환
		Orders entity = dtoToEntity(dto);// 리파지토리에 엔티티를 전달하여 저장
		repository.save(entity);

		return entity.getOrderNo();// 새로 등록된 주문번호를 반환
	}

	@Override
	public OrdersDTO read(int orderNumber) {
		Optional<Orders> result = repository.findById(orderNumber);
		
		if (result.isPresent()) {
			Orders orders = result.get();
			return entityToDto(orders);
		} else {
			return null;
		}

	}

	@Override
	public void modify(OrdersDTO dto) {
		//수정가능한 컬럼은 수령인, 수령인 전화번호, 배송지
		Optional<Orders> result = repository.findById(dto.getOrderNumber());
		
		if(result.isPresent()) {
			Orders entity = result.get();
			
			entity.setReceiverName(dto.getReceiverName());
			entity.setReceiverPhone(dto.getReceiverPhone());
			entity.setShipAddress(dto.getShipAddress());
			
			repository.save(entity);
		}

	}

	@Override
	public void remove(OrdersDTO dto) {
		Optional<Orders> result = repository.findById(dto.getOrderNumber());
		
		if(result.isPresent()) {
			Orders entity = result.get();
			repository.delete(entity);
		}
	}

}
