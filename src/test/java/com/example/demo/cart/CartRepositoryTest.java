package com.example.demo.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class CartRepositoryTest {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@Test
	public void 데이터등록() {
		List<Cart> list = new ArrayList<>();
		Item item1 = Item.builder().itemNo(1).build();
		Member member1 = Member.builder().id("나무라코").build();		
		Item item2 = Item.builder().itemNo(2).build();
		Item item3 = Item.builder().itemNo(3).build();
		
		list.add(new Cart(0, item1, member1, 2));
		list.add(new Cart(0, item2, member1, 3));
		list.add(new Cart(0, item3, member1, 1));
		
		cartRepository.saveAll(list);		
	}
	
	@Test
	public void 데이터조회() {
		Optional<Cart> result = cartRepository.findById(4);
		if(result.isPresent()) {
			Cart cart = result.get();
			
			System.out.println(cart);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Cart> list = cartRepository.findAll();
		
		for(int i = 0; i<list.size(); i++) {
			Cart cart = list.get(i);
			
			System.out.println(cart);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Cart> result = cartRepository.findById(4);
		if(result.isPresent()) {
			Cart cart = result.get();
			
			cart.setCount(13);
			cartRepository.save(cart);
		}
	}
	
	@Test
	public void 데이터삭제() {
		Optional<Cart> result = cartRepository.findById(4);
		if(result.isPresent()) {
			Cart cart = result.get();
			
			cartRepository.delete(cart);
		}
	}
	
	
	
//	@Test
//	@DisplayName("장바구니 엔티티를 생성해서 장바구니 리파지토리에 저장에 성공해야한다.")
//	public void save() {
//		//given
//		Item item2 = itemRepository.findById(2).get();
//		Member aa = memberRepository.findById("aa").get();
//		
//		Cart cart2 = Cart.builder()
////		.cartNo(1)
//		.itemNo(item2)
//		.id(aa)
//		.count(1)
//		.build();
//		
//		//when
//		cartRepository.save(cart2);
//		
//		
////		//then
////		List<Cart> carts = cartRepository.findAll();
////		System.out.println(""+carts.size());
////		
////		Assertions.assertThat(carts).hasSize(1);
//		
//			
//	}
	
//	@Test
//	public void 아이디별로장바구니목록확인test() {
//		
//		List<E>
//		
//	}
	
	@Test
	public void 쿼리테스트1() {
		List<Cart> list = cartRepository.selectCartByID("나무라코");
		for(Cart c : list) {
			System.out.println(c);
		}
		System.out.println();
	}
	
	


}
