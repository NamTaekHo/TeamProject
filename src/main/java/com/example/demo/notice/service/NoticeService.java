package com.example.demo.notice.service;

import org.springframework.data.domain.Page;

import com.example.demo.notice.dto.NoticeDTO;
import com.example.demo.notice.entity.Notice;

public interface NoticeService {
	
	int register (NoticeDTO dto);
	
	Page<NoticeDTO> getList(int page);
	
	NoticeDTO read(int no);
	
	void modify(NoticeDTO dto);
	
	int remove(int no);
	
	default Notice dtoToEntity(NoticeDTO dto) {
		
		Notice entity = Notice.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.writer(dto.getWriter())
				.content(dto.getContent())
				.build();
		return entity;
		
	}
	default NoticeDTO entityToDto(Notice entity) {
		
		NoticeDTO dto = NoticeDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.writer(entity.getWriter())
				.content(entity.getContent())
				.modDate(entity.getModDate())
				.regDate(entity.getRegDate())
				.build();
		return dto;
	}

}
