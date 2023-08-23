package com.example.demo.BoardTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.member.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	public void 데이터등록() {
		List<Board> list = new ArrayList<>();
		Member member = Member.builder().id("aaa").build();
		list.add(new Board(0, "aaaa", "aaaa", member));
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
	
//
//	@Test
//	public void 데이터수정() {
//		Optional<Board> result = repository.findById(2);
//		if(result.isPresent()) {
//			Board board = result.get();
//			board.setId("aaa");		
//			repository.save(board);
//		}
//	}

	
	@Test
	public void 데이터삭제() {
		Optional<Board> result = repository.findById(3);
		if(result.isPresent()) {
			Board board = result.get();
			repository.deleteById(3);
		}
		
	}
}
