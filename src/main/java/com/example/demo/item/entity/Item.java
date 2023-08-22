package com.example.demo.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder //생성자와 같이 객체를 생성하는 메소드를 추가. 생성자와 달리 필요한 값만 입력할 수 있음
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itmeNo; 

    @Column(length = 50, nullable = false)
    private String itemName; //제목

    @Column(nullable = false)
    private int price; //내용

    @Column(length = 100)
    private String image; //작성자
    
    @Column(length = 200)
    private String description;

}
