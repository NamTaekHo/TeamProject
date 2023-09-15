package com.example.demo.ordersItem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.order.entity.Orders;
import com.example.demo.ordersItem.entity.OrdersItem;

import jakarta.transaction.Transactional;

@Transactional
public interface OrdersItemRepository extends JpaRepository<OrdersItem, Integer>{

	// 주문번호로 주문상품 목록 가져오기
	@Query("select oi from OrdersItem oi where oi.oNo = :oNo")
	List<OrdersItem> getOrdersItemByOrders(@Param("oNo") Orders orders);
//	
//	// 주문번호로 주문상품들 삭제하기
//	@Modifying
//	@Query("delete from OrdersItem oi where oi.oNo = :oNo")
//	public void deleteOrdersItemByOrdersNo(@Param("oNo") Orders ordersNo);
}
