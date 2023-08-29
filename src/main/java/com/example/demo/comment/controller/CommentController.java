package com.example.demo.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.service.CommentService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	// 댓글 목록 가져오기
	@GetMapping(value = "/boardList/{boardNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDTO>> getListByBoard(@PathVariable("boardNo") int boardNo){
		log.info("boardNo : " + boardNo);
		
		return new ResponseEntity<>(commentService.getList(boardNo), HttpStatus.OK);
	}
	
	// 댓글 등록
	@PostMapping("/register")
	public ResponseEntity<Integer> register(CommentDTO commentDTO){
		log.info(commentDTO);
		int commentNo = commentService.register(commentDTO);
		return new ResponseEntity<>(commentNo, HttpStatus.OK);
	}
	
	// 댓글 삭제
	@DeleteMapping("/remove/{commentNo}")
	public ResponseEntity<String> remove(@PathVariable("commentNo") int commentNo){
		log.info("commentNo:" + commentNo);
		commentService.remove(commentNo);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	//댓글 수정
	@PostMapping("/modify")
	public ResponseEntity<String> modify(CommentDTO dto){
		log.info("commentNo : " + dto.getCommentNo());
		commentService.modify(dto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
