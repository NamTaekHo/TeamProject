package com.example.demo.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
	
	private String id;
	
	private String password;
	
	private String Email;
	
	private String name;
	
	private String pNumber;
	
	private String address;
	
	private String birth;
	
	private int level;

}
