package com.example.demo.cart.dto;

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
public class CartDTO {
	
	private int no;
	
	private int cartNo;
	
	private int itemNo;
	
	private String itemName;
	
	private int price;
	//아이템 정보 필드 추가
	
	private String id;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
	private int count;
	

}
