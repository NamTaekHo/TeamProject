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
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/board/{boardNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDTO>> getListByBoard(@PathVariable("boardNo") int boardNo){
		log.info("boardNo : " + boardNo);
		
		return new ResponseEntity<>(commentService.getList(boardNo), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Integer> register(@RequestBody CommentDTO commentDTO){
		log.info(commentDTO);
		int commentNo = commentService.register(commentDTO);
		return new ResponseEntity<>(commentNo, HttpStatus.OK);
	}
	
	@DeleteMapping("/{commentNo}")
	public ResponseEntity<String> remove(@PathVariable("commentNo") int commentNo){
		log.info("commentNo:" + commentNo);
		commentService.remove(commentNo);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
}
