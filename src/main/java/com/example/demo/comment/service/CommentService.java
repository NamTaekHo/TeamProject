package com.example.demo.comment.service;

import java.util.List;

import com.example.demo.board.entity.Board;
import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.entity.Comment;
import com.example.demo.member.entity.Member;


public interface CommentService {
	
	//댓글 등록
	int register(CommentDTO commentDTO);
	
	//댓글 조회
	List<CommentDTO> getList(int boardNo);
	
	//댓글 삭제
	void remove(int commentNo);
	
	//DTOtoEntity
	default Comment dtoToEntity(CommentDTO commentDTO) {
		Board board = Board.builder().boardNo(commentDTO.getBoardNo()).build();
		Member member = Member.builder().id(commentDTO.getId()).build();
		
		Comment comment = Comment.builder()
				.commentNo(commentDTO.getCommentNo())
				.content(commentDTO.getContent())
				.board(board)
				.id(member)
				.build();
		return comment;
	}
	
	//EntityToDTO
	default CommentDTO entityToDTO(Comment comment) {
		CommentDTO dto = CommentDTO.builder()
				.commentNo(comment.getCommentNo())
				.boardNo(comment.getBoard().getBoardNo())
				.id(comment.getId().getId())
				.content(comment.getContent())
				.regDate(comment.getRegDate())
				.modDate(comment.getModDate())
				.build();
		
		return dto;
	}
	
}
