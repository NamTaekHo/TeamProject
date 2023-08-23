package com.example.demo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.order.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
