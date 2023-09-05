package com.example.demo.ordersItemTest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.ordersItem.entity.OrdersItem;
import com.example.demo.ordersItem.repository.OrdersItemRepository;

@SpringBootTest
public class OrdersItemRepositoryTest {

	@Autowired
	OrdersItemRepository ordersItemRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 오더아이템등록() {
		Optional<Orders> result1 = orderRepository.findById(1);
		Orders orders = result1.get();
		Optional<Item> result2 = itemRepository.findById(3);
		Item item = result2.get();
		
		OrdersItem oi = OrdersItem.builder()
				.no(0)
				.count(1)
				.price(item.getPrice())
				.iNo(item)
				.oNo(orders).build();
		ordersItemRepository.save(oi);
	}
	
	@Test
	public void 오더아이템조회() {
		List<OrdersItem> list = ordersItemRepository.findAll();
		for(OrdersItem oi : list) {
			System.out.println(oi);
		}
	}
	
	@Test
	public void 오더아이템수정() {
		Optional<OrdersItem> result = ordersItemRepository.findById(2);
		OrdersItem item = result.get();
		item.setCount(2);
		ordersItemRepository.save(item);
	}
	
	@Test
	public void 오더아이템삭제() {
		Optional<OrdersItem> result = ordersItemRepository.findById(3);
		if(result.isPresent()) {
			ordersItemRepository.deleteById(3);
		}
	}
}
