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
	
	private int cartNo;
	
	private int itemNo;
	
	private String id;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
	private int count;
	

}
