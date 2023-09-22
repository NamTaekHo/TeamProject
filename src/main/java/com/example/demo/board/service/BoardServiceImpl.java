package com.example.demo.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@Service
public class BoardServiceImpl implements BoardService {

	// 사용 리파지토리 선언
	@Autowired
	private BoardRepository repository;

	@Autowired
	private CommentRepository commentRepository;





	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto); // 컨트롤러에서 전달받은 dto를 엔티티로 변환
		repository.save(entity); // 리파티토리에 엔티티를 전달하여 저장

		return entity.getBoardNo(); // 새로 등록된 게시물의 번호를 반환
	}

	@Override
	public Page<BoardDTO> getList(int page) {
		int pageNum = (page == 0) ? 0 : page - 1; // page는 index처럼 0부터 시작.
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("boardNo").descending());
		Page<Board> entityPage = repository.findAll(pageable);
		Page<BoardDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));

		return dtoPage;

	}

	@Override
	public BoardDTO read(int no) {
		Optional<Board> result = repository.findById(no);

		if (result.isPresent()) {
			Board board = result.get();
			return entityToDto(board);
		} else {
			return null;
		}
	}

	@Override
	public void modify(BoardDTO dto) {
		// 업데이트 가능 항목은 '제목', '내용'
		Optional<Board> result = repository.findById(dto.getBoardNo());
		if (result.isPresent()) {
			Board entity = result.get();

			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());

			repository.save(entity);
		}

	}

	@Override
	public int remove(int no) {
		Optional<Board> result = repository.findById(no);
		Board board = result.get();
		if (result.isPresent()) {
			commentRepository.deleteCommentByBoard(board);
			repository.deleteById(no);
			return no;
		} else {
			return 0;
		}
	}



}
