package com.example.demo.board.service;

import org.springframework.data.domain.Page;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.entity.Board;

public interface BoardService {

	// 게시물 등록
	int register(BoardDTO dto);
	
	// 게시물 목록조회
	Page<BoardDTO> getList(int page);

	// 게시물 상세조회
	BoardDTO read(int no);

	// 게시물 수정
	void modify(BoardDTO dto);

	// 게시물 삭제
	int remove(int no);
	
	// DTOtoEntity 변환
	default Board dtoToEntity(BoardDTO dto) { // default키워드를 사용하여 일반메소드 추가
//		Member member = Member.builder().id(dto.getWriter()).build(); // 작성자 객체 생성
		
		Board entity = Board.builder() // builder를 사용하면 필요한 값만 넣어서 인스턴스를 생성할수 있음
				.id(dto.getId())
				.title(dto.getTitle())
				.content(dto.getContent())
				.build();
		return entity;
	}
	
	// 엔티티를 dto로 변환하는 메소드
	default BoardDTO entityToDto(Board entity) {

			BoardDTO dto = BoardDTO.builder()
					.id(entity.getId())
					.title(entity.getTitle())
					.content(entity.getContent())
					.build();

			return dto;
		}
}
