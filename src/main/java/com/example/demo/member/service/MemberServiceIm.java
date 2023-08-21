package com.example.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.member.repository.MemberRepository;

@Service
public class MemberServiceIm implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

}
