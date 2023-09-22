package com.example.demo.config.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.member.repository.MemberRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//bean을 따로 등록하지 않아도 사용가능
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	MemberRepository memberRepository;

	//OncePerRequestFilter 메소드 오버라이드
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	//요청 헤더의 Authorization 항목 값을 가져와 jwtHeader 변수에 담음
			throws ServletException, IOException {
		String jwtHeader = ((HttpServletRequest)request).getHeader(JwtProperties.HEADER_STRING);
		
		if(jwtHeader == null || !jwtHeader.startsWith(JwtProperties.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = jwtHeader.replace(JwtProperties.TOKEN_PREFIX, "");
		
		Long memberCode = null;
		
		try {
			memberCode = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token)
					.getClaim("id").asLong();
		} catch (TokenExpiredException e) {
			e.printStackTrace();
			request.setAttribute(JwtProperties.HEADER_STRING, "토큰 만료");
			
		} catch(JWTVerificationException e) {
			e.printStackTrace();
			request.setAttribute(JwtProperties.HEADER_STRING, "유효하지않는 토큰");
			
		}
		
		request.setAttribute("memberCode", memberCode);
		
		filterChain.doFilter(request, response);
				
	}

}
