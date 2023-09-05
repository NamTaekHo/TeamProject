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
import com.example.demo.item.repository.ItemRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class CartRepositoryTest2 {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void 데이터등록() {
		Optional<Member> result1 = memberRepository.findById("나무라코");
		Member m = result1.get();
		Optional<Item> result2 = itemRepository.findById(1);
		Optional<Item> result3 = itemRepository.findById(5);
		Item i1 = result2.get();
		Item i2 = result3.get();
		
		List<Cart> list = new ArrayList<>();
		list.add(new Cart(0, 1, i1, m, 2));
		list.add(new Cart(0, 1, i2, m, 3));
		cartRepository.saveAll(list);
		
		
	}
}
