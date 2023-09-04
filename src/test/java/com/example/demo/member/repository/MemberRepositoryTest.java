package com.example.demo.member.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entity.Member;



@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 데이터등록() {
		Member m = Member.builder()
				.address("인천 구월동")
				.id("aaa")
				.password("aa")
				.Email("sdsd@naver.com")
				.name("둘리")
				.pNumber("010-0000-0000")
				.birth("2000년10월11일")
				.build();
		
		Member m2 = Member.builder()
				.address("인천 가좌동")
				.id("ccc")
				.password("cc")
				.Email("sdsd@naver.com")
				.name("또치")
				.pNumber("010-1111-1111")
				.birth("2001년08월21일")
				.build();
		
		Member m3 = Member.builder()
				.address("인천 석남동")
				.id("bbb")
				.password("bb")
				.Email("sbbbbsd@naver.com")
				.name("도우너")
				.pNumber("010-2222-2222")
				.birth("2003년01월21일")
				.build();
		
		List<Member> list = new ArrayList<>();
		
		list.add(m);
		list.add(m2);
		list.add(m3);
		
		memberRepository.saveAll(list);
		
	}
	
	@Test
	public void 데이터등록2() {
		Member m = Member.builder()
				.address("인천 연수동")
				.id("나무라코")
				.password("aa")
				.Email("sdsd@naver.com")
				.name("둘리")
				.pNumber("010-0000-0000")
				.birth("2000년10월11일")
				.level(1)
				.role("ROLE_ADMIN")
				.build();
		memberRepository.save(m);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Member> result =memberRepository.findById("aaa");
		if(result.isPresent()) {
			Member member = result.get();
			
			System.out.println(member);
		}
	}
	
	
	@Test
	public void 데이터전체조회() {
		List<Member> list = memberRepository.findAll();
		for(Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Member> result = memberRepository.findById("ccc");
		if(result.isPresent()) {
			Member member = result.get();
			member.setPassword("asdf");
			memberRepository.save(member);
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터삭제() {
		Optional<Member> result = memberRepository.findById("ccc");
		if(result.isPresent()) {
			Member member = result.get();
			memberRepository.delete(member);
		}
	}

}
