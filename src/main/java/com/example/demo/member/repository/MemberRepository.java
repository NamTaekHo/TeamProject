package com.example.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
