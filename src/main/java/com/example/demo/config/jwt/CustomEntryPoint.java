package com.example.demo.config.jwt;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//유효기간 토큰 확인 후 예외처리 과정

@Component
public class CustomEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		String exception = (String) request.getAttribute(JwtProperties.HEADER_STRING);
		String errorCode;
		
		if(exception.equals("토큰 만료")) {
			errorCode = "토큰 만료";
			setResponse (response, errorCode);
		}
		
		if(exception.equals("유효하지않는 토큰")) {
			errorCode = "유효하지않는 토큰";
			setResponse(response, errorCode);
			
		}
		
	}

	private void setResponse(HttpServletResponse response, String errorCode) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(JwtProperties.HEADER_STRING + ":" + errorCode);
		
	}

	
}
