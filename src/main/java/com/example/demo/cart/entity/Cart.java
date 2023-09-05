package com.example.demo.cart.entity;

import com.example.demo.config.BaseEntity;
import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Cart extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@Column(nullable = false)
	private int cartNo;
	
	@ManyToOne
	private Item itemNo;

	@ManyToOne
	private Member id;

	@Column(nullable = false)
	private int count;

}
