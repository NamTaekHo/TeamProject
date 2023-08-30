package com.example.demo.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.board.entity.Board;
import com.example.demo.comment.entity.Comment;

import jakarta.transaction.Transactional;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	// board 테이블 삭제시 댓글들 삭제
	// DELETE  FROM COMMENT WHERE board_board_no = 29;
	@Modifying
	@Query("delete from Comment c where c.board  = :boardNo")
	void deleteCommentByBoard(@Param("boardNo") Board boardNo);
	
	// 게시물로 댓글 목록 가져오기
	List<Comment> getCommentByBoardOrderByCommentNo(Board board);
}
