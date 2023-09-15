package com.example.demo.order;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
		
		Optional<Member> result = memberRepository.findById("나무라코");
		Member m = result.get();
		
		Orders o = new Orders(0, m, m.getName(), m.getPNumber(), m.getAddress(), 51220);
		orderRepository.save(o);
	}
	
	@Test
	public void 주문조회() {
		Optional<Orders> result = orderRepository.findById(1);
		Orders order = result.get();
		System.out.println(order);
	}
	
	@Test
	public void 쿼리테스트() {
		int page = 1;
		int pageNum = (page == 0) ? 0 : page - 1; //page는 index처럼 0부터 시작.
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("orderNo").descending());
		Page<Orders> result = orderRepository.getOrdersByMemberId("나무라코", pageable);
		
		for(Orders o : result) {
			System.out.println(o);
		}
	}
	
	
}
