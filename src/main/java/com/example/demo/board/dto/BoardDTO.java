package com.example.demo.board.dto;

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
public class BoardDTO {

	private int boardNo;
	private String id;
	private String title;
	private String content;
	private LocalDateTime regDate;
    private LocalDateTime modDate;
}
