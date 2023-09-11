package com.example.demo.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.ordersItem.repository.OrdersItemRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrdersItemRepository ordersItemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	MemberRepository memberRepository;
	

	@Override
	public int register(String memberId) {
		// 인자로 전달받은 String id 로 멤버 객체 찾기
		Optional<Member> result = memberRepository.findById(memberId);
		Member member = result.get();
		
		
		//회원 아이디 사용해서 장바구니 목록 가져오기
		List<Cart> cartlist = cartRepository.getCartByMemberId(memberId);
		List<Orders> olist = new ArrayList<>();
		for(Cart cart : cartlist) {
			Orders orders = Orders.builder()
					.orderNo(0)
					.id(member)
					.receiverName(member.getName())
					.receiverPhone(member.getPNumber())
					.shipAddress(member.getAddress())
					.totalPrice(0)
					.build();
			olist.add(orders);
					

		}
		

		return 0;
	}
	
	@Override
	public Page<OrdersDTO> getList(int page) {
		int pageNum = (page == 0) ? 0 : page - 1; //page는 index처럼 0부터 시작.
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("orderNo").descending());
		Page<Orders> entityPage = orderRepository.findAll(pageable);
		Page<OrdersDTO> dtoPage = entityPage.map(entity -> entityToDTO(entity));
		
		return dtoPage;
	}

	@Override
	public OrdersDTO read(int orderNo) {
		Optional<Orders> result = orderRepository.findById(orderNo);
		if(result.isPresent()) {
			Orders orders = result.get();
			return entityToDTO(orders);
		} else {
			return null;
		}
		
	}
	
	@Override
	public void remove(int orderNo) {
		Optional<Orders> result = orderRepository.findById(orderNo);
		if(result.isPresent()) {
			orderRepository.deleteById(orderNo);
			System.out.println(orderNo + " 번 주문이 삭제되었습니다.");
		}
		
	}

	

}
