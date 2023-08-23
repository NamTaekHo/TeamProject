package com.example.demo.notice.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.notice.dto.NoticeDTO;
import com.example.demo.notice.entity.Notice;

import jakarta.validation.ReportAsSingleViolation;

@SpringBootTest
public class NoticeServiceTest {
	
	@Autowired
	NoticeService service;
	
	@Test
	public void 공지등록() {
		for(int i=1; i<=32; i++) {
			NoticeDTO dto = NoticeDTO.builder()
					.title("제목"+i)
					.content("내용"+i)
					.writer("작성자"+i)
					.build();
			service.register(dto);
		}
	}
	
	@Test
	public void 공지목록조회() {
		Page<NoticeDTO> page = service.getList(2);
		List<NoticeDTO> list = page.getContent();
		for(NoticeDTO dto : list) {
			System.out.println(dto);
		}		
	}
	
	@Test
	public void 공지단건조회() {
		NoticeDTO dto =service.read(16);
		System.out.println(dto);
	}
	
	@Test
	public void 공지수정() {
		NoticeDTO dto = service.read(16);
		dto.setTitle("16번 공지 수정");
		dto.setContent("공지가 수정됨");
		service.modify(dto);
	}
	
	@Test
	public void 공지삭제() {
		service.remove(16);
	}
	
	
	
	
	

}
