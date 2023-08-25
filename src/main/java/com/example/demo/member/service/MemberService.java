package com.example.demo.member.service;

import org.springframework.data.domain.Page;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;

public interface MemberService {
	
	
	Page<MemberDTO> getlist(int pageNumber);//회원 목록조회
	
	boolean register(MemberDTO dto);//회원 등록
	
	MemberDTO read(String id);//회원 단건 조회
	
	void modify(MemberDTO dto);//마이페이지 수정
	
	void delete(MemberDTO dto);//회원삭제
	

	//회원 엔티티를 멤버 dto로 변환
	default MemberDTO entityToDto(Member entity) {
		MemberDTO dto = MemberDTO.builder()
				.id(entity.getId())
				.password(entity.getPassword())
				.Email(entity.getEmail())
				.name(entity.getName())
				.pNumber(entity.getPNumber())
				.address(entity.getAddress())
				.birth(entity.getBirth())
				.level(entity.getLevel())
				.build();

		return dto;
	}
	
	//회원 dto를 엔티티로 변환
	default Member DtoToEntity(MemberDTO dto) {
		Member entity = Member.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.Email(dto.getEmail())
				.name(dto.getName())
				.pNumber(dto.getPNumber())
				.address(dto.getAddress())
				.birth(dto.getBirth())
				.level(dto.getLevel())
				.build();
		
		return entity;
	}

	

}
