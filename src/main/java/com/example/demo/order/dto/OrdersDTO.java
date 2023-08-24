package com.example.demo.order.dto;

import java.time.LocalDateTime;

import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDTO {
	
	private int orderNumber;
	
	private int itemNo;
	
	private String id;
	
	private LocalDateTime orderDate;
	
	private String receiverName;
	
	private String receiverPhone;
	
	private String shipAddress;
	
	private double discount;// 할인율을 뷰단에 보낼변수
	
	private String itemName;//DB로부터 꺼내올 값
	
	private int level;//DB로부터 꺼내올 값
	
	private int price;//DB로부터 꺼내올 값

}
