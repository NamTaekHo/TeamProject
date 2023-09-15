package com.example.demo.member.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.MemberServiceImpl;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	MemberService service;
	
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void 회원등록() {

		for (int i = 1; i < 3; i++) {
		MemberDTO dto = new MemberDTO(i+"aa", "aa", null, "둘리", "010-1234-5678", "인천광역시 남동구 구월로 2-54번지 구월그린컴퓨터아트학원", "2000년10월20일", 0,"ROLE_USER");
			service.register(dto);
		}
	}
	
	@Test
	public void 회원등록1() {

		MemberDTO dto = new MemberDTO("sd", "123", null, "또치", "ㅁㄴㅇ", "ㅁㅁㅁ", "ㅁㅁㅁㅁㅁ", 0, "ROLE_USER");
			service.register(dto);
	}
	
	
	@Test
	public void 회원목록조회() {
		Page<MemberDTO> page = service.getlist(1);
		List<MemberDTO> list = page.getContent();
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 회원정보수정() {
		MemberDTO dto = service.read("aa");
		dto.setEmail("sadasd@naver.com");
		dto.setAddress("sdsdsd");
		service.modify(dto);
	}
	
	@Test
	public void 데이터삭제() {
		MemberDTO dto = service.read("9aa");
		service.delete(dto);
	}
	
	@Test
	public void 데이터삭제2() {
		service.remove("cc");
		System.out.println();
	}

}
