package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//메뉴별 접근제한 설정
		http.authorizeHttpRequests()
		.requestMatchers("/main").permitAll()
		.requestMatchers("/assets/*","/css/*","/js/*").permitAll()
		.requestMatchers("/register").permitAll()
		.requestMatchers("/member/read").hasAnyRole("ADMIN","USER")
		.requestMatchers("/member/memberlist").hasAnyRole("ADMIN")
		.requestMatchers("/board/*").hasAnyRole("ADMIN","USER")
		.requestMatchers("/notice/*").hasAnyRole("ADMIN","USER");
		
		http.formLogin();
		http.csrf().disable();
		http.logout();
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
