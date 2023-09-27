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
public class SecurityConfig{
	
	


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers("/register").permitAll()
		.requestMatchers("/assets/**" ,"/css/*","/js/*","/aa/**").permitAll()
		.requestMatchers("/comment/**").hasAnyRole("ADMIN","USER")
		.requestMatchers("/").hasAnyRole("ADMIN","USER")
		.requestMatchers("/member/read").hasAnyRole("ADMIN","USER")
		.requestMatchers("/member/memberlist","/member/modify","/member/remove").hasAnyRole("ADMIN")
		.requestMatchers("/item/**").hasAnyRole("ADMIN","USER")
		.requestMatchers("/board/**", "/orders/**", "/map/**").hasAnyRole("ADMIN","USER")
		.requestMatchers("/cart/**").hasAnyRole("ADMIN","USER")
		.requestMatchers("/notice/**").hasAnyRole("ADMIN","USER");
		
		http.formLogin();
		http.csrf().disable();
		http.logout();
		
//		http.oauth2Login()
//		.defaultSuccessUrl("/register");
		
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
