package com.example.demo.BoardTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.service.BoardService;

@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService service;
	
	@Test
	public void 게시물등록() {
		for(int i = 1; i<=30; i++) {
			BoardDTO dto = new BoardDTO(i, "제목"+i, "내용"+i, "taco", null, null);
			service.register(dto);
		}
	}
}
