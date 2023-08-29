package com.example.demo.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Member {

	@Id
	@Column(length = 10)
	private String id;

	@Column(length = 15, nullable = false)
	private String password;

	@Column(length = 30, nullable = true)
	private String Email;

	@Column(length = 10, nullable = false)
	private String name;

	@Column(length = 15, nullable = false)
	private String pNumber;

	@Column(length = 255, nullable = false)
	private String address;

	@Column(length = 11, nullable = false)
	private String birth;

	@Column(nullable = true)
	private int level;

	@Column(length = 30 , nullable = false)
	private String role;

}
