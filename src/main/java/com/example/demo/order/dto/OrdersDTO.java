package com.example.demo.order.dto;

import java.time.LocalDateTime;

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
	
	private int orderNo;

	private String id;
	
	private LocalDateTime orderDate;
	
	private String receiverName;
	
	private String receiverPhone;
	
	private String shipAddress;
	
	private double totalPrice;


}
