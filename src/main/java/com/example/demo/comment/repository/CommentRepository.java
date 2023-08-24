package com.example.demo.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Board;
import com.example.demo.comment.entity.Comment;

import jakarta.transaction.Transactional;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
//	// board 테이블 삭제시 댓글들 삭제
//	@Modifying
//	@Query("delete c from comment c where c.BOARD_BOARD_NO  = :boardNo")
//	void deleteBy(@Param("boardNo") int boardNo);
	
	// 게시물로 댓글 목록 가져오기
	List<Comment> getCommentByBoardOrderByCommentNo(Board board);
}
