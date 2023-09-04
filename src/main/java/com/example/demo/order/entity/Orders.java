package com.example.demo.order.entity;

import com.example.demo.config.BaseEntity;
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
public class Orders extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderNo;

	@ManyToOne
	private Member id;

	@Column(length = 10, nullable = true)
	private String receiverName;

	@Column(length = 20, nullable = true)
	private String receiverPhone;

	@Column(length = 255, nullable = true)
	private String shipAddress;
	
	@Column(nullable = false)
	private double totalPrice;
}
