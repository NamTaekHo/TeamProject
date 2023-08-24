package com.example.demo.comment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.entity.Board;
import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.entity.Comment;
import com.example.demo.comment.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public int register(CommentDTO commentDTO) {
		Comment comment = dtoToEntity(commentDTO);
		commentRepository.save(comment);
		
		return comment.getCommentNo();
	}

	@Override
	public List<CommentDTO> getList(int boardNo) {
		List<Comment> list = commentRepository.getCommentByBoardOrderByCommentNo(Board.builder()
				.boardNo(boardNo)
				.build());
		
		return list.stream().map(comment -> entityToDTO(comment)).collect(Collectors.toList());
	}

	@Override
	public void remove(int commentNo) {
		commentRepository.deleteById(commentNo);
		
	}
	
	
}
