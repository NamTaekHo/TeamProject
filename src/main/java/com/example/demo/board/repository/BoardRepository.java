package com.example.demo.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.board.entity.Board;
import com.example.demo.member.entity.Member;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer> {
//	delete from board where board.id_id  = '나무라코';
	@Modifying
	@Query("delete from Board b where b.id = :memberId")
	void deleteBoardByMember(@Param("memberId") Member id);
	
	@Query("select b from Board b where b.id = :memberId")
	List<Board> getBoardByMember(@Param("memberId") Member id);
}
