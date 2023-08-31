package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.CustomUser;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberService service;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("login id : " + userName); // username은 아이디를 의미
		MemberDTO dto = service.read(userName);

		if (dto == null) { // 사용자가 존재하지 않을때 에러를 발생시킴
			throw new UsernameNotFoundException("");
		} else {
			return new CustomUser(dto); // 사용자도메인을 시큐리티 인중객체로 변환
		}

	}

}
