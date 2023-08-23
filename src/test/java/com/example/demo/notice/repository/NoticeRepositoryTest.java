package com.example.demo.notice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.notice.dto.NoticeDTO;
import com.example.demo.notice.entity.Notice;
import com.example.demo.notice.repository.NoticeRepository;

@SpringBootTest
public class NoticeRepositoryTest {
	
	@Autowired
	NoticeRepository repository;
	
	@Test
	public void 공지등록() {
		List<Notice> list= new ArrayList<>();
		list.add(new Notice(0, "wer", "rew", "wer"));
		list.add(new Notice(0, "d123213d", "a12sdf", "fdaasdasds"));
		list.add(new Notice(0, "ddddsad", "axvsdf", "fasdsaddas"));
		list.add(new Notice(0, "ddsad", "axsdf", "faddas"));
		list.add(new Notice(0, "ddewwwwwd", "axvesdf", "fasjfdsdsaddas"));
		repository.saveAll(list);
	}
	
	@Test
	public void 공지단건조회() {
		Optional<Notice> result = repository.findById(3);
		if(result.isPresent()) {
			Notice notice = result.get();
			System.out.println(notice);
		}		
	}
	
	@Test
	public void 공지전체조회() {
		List<Notice> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void 공지수정() {
		Optional<Notice> result = repository.findById(3);
		if(result.isPresent()) {
			Notice notice =result.get();
			notice.setContent("공지가 수정됨");
			notice.setTitle("수정된 공지입니다.");
			
			repository.save(notice);			
		}
	}
	
	@Test
	public void 공지삭제() {
		Optional<Notice> result = repository.findById(3);
		if(result.isPresent()) {
			Notice notice =result.get();
			repository.delete(notice);
//			Notice notice =result.get();
//			repository.deleteById(3);
			
		}
	}	

}
