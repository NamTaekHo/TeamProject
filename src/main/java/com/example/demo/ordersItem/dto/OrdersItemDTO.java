package com.example.demo.ordersItem.dto;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersItemDTO {
	
	private int no;
	
	private int iNo;
	
	private int oNo;
	
	private int price;
	
	private int count;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
}
