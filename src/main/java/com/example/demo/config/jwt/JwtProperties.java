package com.example.demo.config.jwt;

public interface JwtProperties {
	
	//JWT의 signature를 해싱할 때 사용되는 비밀 키
	String SECRET = "{}";
	
	//토큰 만료 기간. 초 단위로 계산,<refresh_token>을 사용하지 않는다면 설정
	int EXPIRATION_TIME = 864000000;
	
	//토큰 앞에 붙는 정해진 형식. bearer 뒤에 한 칸 공백을 넣어줘야 함
	String TOKEN_PREFIX = "bearer";
	
	//헤더의 Authorization 이라는 항목에 토큰을 넣어줄 것
	String HEADER_STRING = "Authorization";

}
