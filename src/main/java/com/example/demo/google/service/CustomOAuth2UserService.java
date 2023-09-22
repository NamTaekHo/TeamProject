//package com.example.demo.google.service;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.member.entity.Member;
//import com.example.demo.member.repository.MemberRepository;
//
//import jakarta.servlet.http.HttpSession;
//
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//	@Autowired
//	MemberRepository memberRepository;
//
//	@Autowired
//	HttpSession httpSession;
//
//	@Override
//	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//		OAuth2UserService delegate = DefaultOAuth2UserService();
//		OAuth2User auth2User = delegate.loadUser(userRequest);
//		
//		//서비스 구분을 위한 작업(구글: google, 네이버: naver)
//		String registationId = userRequest.getClientRegistration().getRegistrationId();
//
//		String userNameAttributeName = userRequest.getClientRegistration()
//				.getProviderDetails()
//				.getUserInfoEndpoint()
//				.getUserNameAttributeName();
//		
//		String Email;
//		Map<String, Object> response = auth2User.getAttributes();
//		
//		if(registationId.equals("google")) {
//			Email = (String) response.get(Email);
//		} else {
//			throw new OAuth2AuthenticationException("허용되지 않는 인증입니다.");
//		}
//		
//		Member member;
//		Optional<Member> optionalMember = memberRepository.findById(member.getId());
//		
//		if(optionalMember.isPresent()) {
//			member = optionalMember.get();
//		}else {
//			member = new Member();
//			member.setId(Email);
//			member.setRole("ROLE_USER");
//			memberRepository.save(member);
//		} 
//		
//		httpSession.setAttribute("name", member);
//		
//		return new DefaultOAuth2User(
//				Collections.singleton(new SimpleGrantedAuthority(member.getRole()))
//				, auth2User.getAttributes()
//				, userNameAttributeName);
//	}
//				
//				
//				
//				
//				
//				
//				
//				
//				
//	private OAuth2UserService DefaultOAuth2UserService() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//}
