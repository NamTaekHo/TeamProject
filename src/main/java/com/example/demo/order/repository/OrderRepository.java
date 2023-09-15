package com.example.demo.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.order.entity.Orders;

import jakarta.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	@Query("select o from Orders o where o.id.id = :memberId")
	Page<Orders> getOrdersByMemberId(@Param("memberId") String memberId, Pageable pageable);
	
	@Modifying
	@Query("delete from Orders o where o.id.id = :memberId")
	void deleteByOrdersByMemberId(@Param("memberId") String memberId);
}
