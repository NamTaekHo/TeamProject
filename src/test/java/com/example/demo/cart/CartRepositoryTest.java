package com.example.demo.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;

@SpringBootTest
public class CartRepositoryTest {

	@Autowired
	CartRepository repository;

	@Test
	public void 데이터등록() {
		List<Cart> list = new ArrayList<>();
		Item item1 = Item.builder().itemNo(1).build();
		Member member1 = Member.builder().id("10aa").build();
		
		Item item2 = Item.builder().itemNo(23).build();
		Member member2 = Member.builder().id("11aa").build();
		
		Item item3 = Item.builder().itemNo(30).build();
		Member member3 = Member.builder().id("12aa").build();
		
		list.add(new Cart(0, item1, member1, 0));
		list.add(new Cart(0, item2, member2, 0));
		list.add(new Cart(0, item3, member3, 0));
		list.add(new Cart(0, item1, member3, 0));
		
		repository.saveAll(list);		
	}
	
	@Test
	public void 데이터조회() {
		Optional<Cart> result = repository.findById(4);
		if(result.isPresent()) {
			Cart cart = result.get();
			
			System.out.println(cart);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Cart> list = repository.findAll();
		
		for(int i = 0; i<list.size(); i++) {
			Cart cart = list.get(i);
			
			System.out.println(cart);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Cart> result = repository.findById(4);
		if(result.isPresent()) {
			Cart cart = result.get();
			
			cart.setCount(13);
			repository.save(cart);
		}
	}
	
	@Test
	public void 데이터삭제() {
		Optional<Cart> result = repository.findById(4);
		if(result.isPresent()) {
			Cart cart = result.get();
			
			repository.delete(cart);
		}
	}

}
