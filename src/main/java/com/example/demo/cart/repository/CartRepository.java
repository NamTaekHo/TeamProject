package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.cart.entity.Cart;

import jakarta.transaction.Transactional;

@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {

	// 멤버의 아이디로 장바구니 목록 불러오기
	// SELECT *FROM CART WHERE cart.ID_ID = '나무라코';
	@Query("select c from Cart c where c.ID = :memberID")
	void selectCartByID();
}


