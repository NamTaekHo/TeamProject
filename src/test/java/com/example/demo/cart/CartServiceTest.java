package com.example.demo.cart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.service.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService service;
	
//	@Test
//	public void 데이터등록() {
//		for(int i = 0; i<30; i++) {
//			service.register(new CartDTO(i, 1, "10aa", null, null, i));
//		}
//	}
	
	@Test
	public void 데이터조회() {
		CartDTO dto = service.read(14);
		
		System.out.println(dto);
	}
	
	@Test
	public void 데이터전체조회() {
	}

}
