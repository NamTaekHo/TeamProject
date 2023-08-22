package com.example.demo.order;

import java.util.ArrayList;
import java.util.List;

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
//		Member member2 = Member.builder().id("bbb").build();
//		Member member3 = Member.builder().id("ccc").build();
		
		Item item1 = Item.builder().itemNo(1).build();
//		Item item2 = Item.builder().itemNo(2).build();
//		Item item3 = Item.builder().itemNo(3).build();
//		Item item4 = Item.builder().itemNo(4).build();
//		Item item5 = Item.builder().itemNo(5).build();
		
		list.add(new Orders(0, item1, member1, null, null, null));
		
		orderRepository.saveAll(list);
	}

}
