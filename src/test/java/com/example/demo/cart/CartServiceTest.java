package com.example.demo.cart;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.cart.service.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService service;
	
	@Autowired
	CartRepository cartRepository;
	
//	@Test
//	public void 데이터등록() {
//		for(int i = 0; i<3; i++) {
//			service.register(new CartDTO(i, 1, "sd", null, null, i, i));
//		}
//	}
	
//	@Test
//	public void 데이터조회() {
//		CartDTO dto = service.read(14);
//		
//		System.out.println(dto);
//	}
	
	@Test
	public void 데이터전체조회() {
	}
	
	@Test
	public void 디버깅용() {
		Optional<Cart> result = cartRepository.findById(6);
		Cart cart = result.get();
		CartDTO dto = service.entityToDto(cart);
		System.out.println(dto);
	}

}
