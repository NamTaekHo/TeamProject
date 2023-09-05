package com.example.demo.ordersItem.entity;

import com.example.demo.config.BaseEntity;
import com.example.demo.item.entity.Item;
import com.example.demo.order.entity.Orders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersItem extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@ManyToOne
	private Item iNo;
	
	@ManyToOne
	private Orders oNo;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private int count;
}
