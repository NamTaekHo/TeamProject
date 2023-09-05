package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cart.entity.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	//사용자 아이디별로 목록조회 메소드 추가 -> 단위테스트 확인

}


