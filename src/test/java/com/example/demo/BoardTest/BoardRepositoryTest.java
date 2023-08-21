package com.example.demo.BoardTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	public void 데이터등록() {
		List<Board> list = new ArrayList<>();
		list.add(new Board(0, "ta", "제목", "내용1"));
		list.add(new Board(0, "tae", "제목2", "내용2"));
		list.add(new Board(0, "taek", "제목3", "내용3"));
		repository.saveAll(list);
		
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = repository.findById(1);
		if(result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Board> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 데이터수정() {
		Optional<Board> result = repository.findById(2);
		if(result.isPresent()) {
			Board board = result.get();
			board.setId("taekho");
			repository.save(board);
		}
	}
	
	@Test
	public void 데이터삭제() {
		Optional<Board> result = repository.findById(3);
		if(result.isPresent()) {
			Board board = result.get();
			repository.deleteById(3);
		}
		
	}
}
