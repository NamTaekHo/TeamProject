package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;

public interface MemberService {
	

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
