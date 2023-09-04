package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.repository.ItemRepository;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.repository.OrderRepository;

@SpringBootTest
public class OrdersRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
//	@Test
//	public void 주문등록() {
//		Item i = Item.builder().itemNo(2).build();
//		Member m = Member.builder().id("나무라코").build();
//		
//		
//		
//		orderRepository.save(o1);
//	}
}
