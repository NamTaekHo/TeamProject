package com.example.demo.CommentTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.comment.entity.Comment;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository repository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 댓글등록() {
		Member member = Member.builder().id("bbb").build();
		Board board = Board.builder().boardNo(30).build();
		Comment comment = new Comment(0, board, member, "댓글내용2");
		repository.save(comment);
		
		Member member2 = Member.builder().id("aaa").build();
		Board board2 = Board.builder().boardNo(30).build();
		for(int i = 0; i<10; i++) {
			List<Comment> list = new ArrayList<>();
			list.add(new Comment(0, board, member, "댓글내용"+i));
			repository.saveAll(list);
		}
	}
	
	@Test
	public void 게시물로댓글가져오기() {
		Board board = Board.builder().boardNo(30).build();
		List<Comment> list = repository.getCommentByBoardOrderByCommentNo(board);
		list.forEach(comment -> System.out.println(comment));
	}
}
