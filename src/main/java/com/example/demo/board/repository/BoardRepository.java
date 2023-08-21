package com.example.demo.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Board;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
