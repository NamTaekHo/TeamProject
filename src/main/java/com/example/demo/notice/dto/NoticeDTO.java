package com.example.demo.notice.dto;

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
public class NoticeDTO {
	
	private int no;
	private String title;
	private String writer;
	private String content;	
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	

}