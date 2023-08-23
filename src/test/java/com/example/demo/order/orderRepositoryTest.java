package com.example.demo.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;


@SpringBootTest
public class orderRepositoryTest {
	
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 데이터등록() {
		List<Orders> list = new ArrayList<>();
		Member member1 = Member.builder().id("aaa").build();
		Member member2 = Member.builder().id("bbb").build();
		Member member3 = Member.builder().id("ccc").build();
		
		Item item1 = Item.builder().itemNo(1).build();
		Item item2 = Item.builder().itemNo(2).build();
		Item item3 = Item.builder().itemNo(3).build();
		Item item4 = Item.builder().itemNo(4).build();
		Item item5 = Item.builder().itemNo(5).build();
		
		list.add(new Orders(0, item1, member1, null, null, null));
		list.add(new Orders(0, item2, member1, null, null, null));
		list.add(new Orders(0, item2, member1, null, null, null));
		list.add(new Orders(0, item3, member3, null, null, null));
		list.add(new Orders(0, item3, member3, null, null, null));
		list.add(new Orders(0, item4, member2, null, null, null));
		list.add(new Orders(0, item4, member2, null, null, null));
		list.add(new Orders(0, item5, member2, null, null, null));
		
		
		orderRepository.saveAll(list);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Orders> result = orderRepository.findById(5);
		if(result.isPresent()) {
			Orders orders = result.get();
			
			System.out.println(orders);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Orders> list = orderRepository.findAll();
		for(int i = 0; i<list.size(); i++) {
			Orders orders = list.get(i);
			
			System.out.println(orders);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Orders> result = orderRepository.findById(8);
		if(result.isPresent()) {
			Orders orders = result.get();
			
			orders.setReceiverName("마이콜");
			orderRepository.save(orders);
		}
	}
	
	@Test
	public void 데이터삭제() {
		Optional<Orders> result = orderRepository.findById(7);
		if(result.isPresent()) {
			Orders orders = result.get();
			orderRepository.delete(orders);
		}
	}

}
