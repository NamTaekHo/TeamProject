package com.example.demo.order;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;

@SpringBootTest
public class OrdersRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void 주문등록() {
		Item i = Item.builder()
				.itemNo(2)
				.build();
		Member m = Member.builder()
				.id("나무라코")
				.build();
		Orders o = new Orders(0, m, "남택호", "01024015119", "유천아파트", 4);
		orderRepository.save(o);
	}
	
	@Test
	public void 주문조회() {
		Optional<Orders> result = orderRepository.findById(1);
		Orders order = result.get();
		System.out.println(order);
	}
	
	
}
