package com.example.demo.item.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

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
	private String image;//파일 이름
	private String description;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private MultipartFile uploadFile; //파일 스트림
	//카테고리 추가해보기
	private String category;
	
}
