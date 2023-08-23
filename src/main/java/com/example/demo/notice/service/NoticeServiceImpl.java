package com.example.demo.notice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.notice.dto.NoticeDTO;
import com.example.demo.notice.entity.Notice;
import com.example.demo.notice.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepository repository;
	

	@Override
	public int register(NoticeDTO dto) {
		Notice entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getNo();
	}

	@Override
	public Page<NoticeDTO> getList(int page) {
		int pageNum = (page ==0)? 0 :page-1;
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("no").descending());
		Page<Notice> entityPage = repository.findAll(pageable);
		Page<NoticeDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));

		return dtoPage;
	}

	@Override
	public NoticeDTO read(int no) {
		Optional<Notice> result = repository.findById(no);
		
		if(result.isPresent()) {
			Notice notice =result.get();
			return entityToDto(notice);
		}else {
			return null;	
		}
		
	}

	@Override
	public void modify(NoticeDTO dto) {
		Optional<Notice> result = repository.findById(dto.getNo());
		if(result.isPresent()) {
			Notice entity = result.get();
			
			entity.setContent(dto.getContent());
			entity.setTitle(dto.getTitle());
			
			repository.save(entity);
		}

		
	}

	@Override
	public int remove(int no) {
		Optional<Notice> result = repository.findById(no);
		if(result.isPresent()) {
			repository.deleteById(no);
			return 1; //성공
		} else {
			return 0; //실패
		}	
	}

}
