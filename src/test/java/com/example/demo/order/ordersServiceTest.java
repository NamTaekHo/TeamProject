package com.example.demo.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.service.OrderService;

@SpringBootTest
public class ordersServiceTest {
	
	@Autowired
	OrderService service;
	
//	@Test
//	public void 데이터등록() {
//		Member member = Member.builder().id("aaa").build();
//		Item item = Item.builder().itemNo(3).build();
//		
//		for(int i = 0; i< 30; i++) {
//			service.register(new OrdersDTO(i, item, member, null, null, null, null);
//		}
//	}

}
