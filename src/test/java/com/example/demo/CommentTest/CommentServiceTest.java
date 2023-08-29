package com.example.demo.CommentTest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.entity.Comment;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.comment.service.CommentService;

@SpringBootTest
public class CommentServiceTest {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void 댓글목록조회() {
		
		int boardNo = 29;
		
		List<CommentDTO> list = commentService.getList(boardNo);
		list.forEach(commentDTO -> System.out.println(commentDTO));
	}
	
	@Test
	public void 댓글등록() {
		CommentDTO dto = new CommentDTO(0, 29, "aaa", "댓글내용88", null, null);
		commentService.register(dto);
		
	}
	
	@Test
	public void 댓글삭제() {
		commentService.remove(13);
	}
	
	@Test
	public void 댓글수정() {
		Optional<Comment> result = commentRepository.findById(31);
		if(result.isPresent()) {
			Comment comment = result.get();
			CommentDTO dto = commentService.entityToDTO(comment);
			dto.setContent("지금 수정중");
			commentService.modify(dto);
		}
	}
}
