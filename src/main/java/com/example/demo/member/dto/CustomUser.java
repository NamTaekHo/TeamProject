package com.example.demo.member.dto;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	public CustomUser(MemberDTO dto) {
		super(dto.getId(), dto.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(dto.getRole())));
	}

}
