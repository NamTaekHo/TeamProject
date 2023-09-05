package com.example.demo.ordersItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ordersItem.entity.OrdersItem;

public interface OrdersItemRepository extends JpaRepository<OrdersItem, Integer>{

}
