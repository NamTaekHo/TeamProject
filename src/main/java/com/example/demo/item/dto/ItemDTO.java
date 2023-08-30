package com.example.demo.item.dto;

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
public class ItemDTO {
	
	private int itemNo;
	private String itemName;
	private int price;
	private String image;
	private String description;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	

}
