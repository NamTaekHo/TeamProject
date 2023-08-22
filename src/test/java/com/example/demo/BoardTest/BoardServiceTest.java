package com.example.demo.BoardTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.service.BoardService;

// 등록일, 수정일 null값 뜸
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService service;
	
	@Test
	public void 게시물등록() {
		for(int i = 1; i<=30; i++) {
			BoardDTO dto = BoardDTO.builder()
					.id("taco")
					.content("내용"+i)
					.title("제목"+i)
					.build();
			service.register(dto);
		}
	}
	
	@Test
	public void 첫번째페이지조회() {
		Page<BoardDTO> page = service.getList(2);
		List<BoardDTO> list = page.getContent();
		for(BoardDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 게시물단건조회() {
		BoardDTO dto = service.read(3);
		System.out.println(dto);
	}
	
	@Test
	public void 게시물수정() {
		BoardDTO dto = service.read(1);
		dto.setContent("내용수정");
		service.modify(dto);
	}
	
	@Test
	public void 게시물삭제() {
		service.remove(2);
	}
}
