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
import com.example.demo.ordersItem.entity.OrdersItem;
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
	

	// 주문 등록(주문 등록과 동시에 주문 상품에 장바구니 내 아이템 등록)
	@Override
	public int register(String memberId) {
		// 인자로 전달받은 String id 로 멤버 객체 찾기
		Optional<Member> result = memberRepository.findById(memberId);
		Member member = result.get();
		
		// 찾은 멤버 객체 사용해서 orders 생성
		Orders orders = Orders.builder()
				.orderNo(0)
				.id(member)
				.receiverName(member.getName())
				.receiverPhone(member.getPNumber())
				.shipAddress(member.getAddress())
				// totalPrice는 뷰단에서 처리
				.totalPrice(0)
				.build();
		orderRepository.save(orders);
		
		
		// 인자로 받은 memberId로 장바구니 목록 찾아서 주문상품목록에 등록
		List<Cart> cartlist = cartRepository.getCartByMemberId(memberId);
		List<OrdersItem> oItemList = new ArrayList<>();
		for(Cart cart : cartlist) {
			OrdersItem oi = OrdersItem.builder()
					.no(0)
					.iNo(cart.getItemNo())
					.oNo(orders)
					.price(cart.getItemNo().getPrice())
					.count(cart.getCount())
					.build();
			oItemList.add(oi);
			// 장바구니 내 상품 등록 후 주문한 상품은 장바구니에서 삭제
			cartRepository.deleteById(cart.getNo());
		}
		ordersItemRepository.saveAll(oItemList);
		
		// 주문번호 반환
		return orders.getOrderNo();
	}
	
	@Override
	public Page<OrdersDTO> getList(int page, String memberId) {
		int pageNum = (page == 0) ? 0 : page - 1; //page는 index처럼 0부터 시작.
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("orderNo").descending());
		Page<Orders> entityPage = orderRepository.getOrdersByMemberId(memberId, pageable);
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
			System.out.println(orderNo + " 번 주문내역이 삭제되었습니다.");
		}
		
	}

	

}
