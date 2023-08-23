package com.example.demo.board.entity;

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

// id컬럼에 나중에 머지하고 외래키 @manytoone 걸어야함
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends    BaseEntity{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int boardNo;
   
//   @Column(length = 10, nullable = false)
//   String Writer;
   
   @Column(length = 30, nullable = false)
   String title;
   
   @Column(length = 1500, nullable = false)
   String content;
   
   @ManyToOne
   private Member id;
}
