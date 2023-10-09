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
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/sidebar_templates/**","/aa/**","/register").permitAll()

		.requestMatchers("/member/read", "member/**","/board/**", "/orders/**",
				"/map/**","/cart/**","/notice/**","/comment/**","/","/item/**").hasAnyRole("ADMIN","USER")

		.requestMatchers("/member/memberlist","/member/modify","/member/remove").hasAnyRole("ADMIN");


		
		http.formLogin();
		http.csrf().disable();
		http.logout();
		
		http.formLogin()
		.loginPage("/customlogin")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/",true)
		.permitAll();
		
	
		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
