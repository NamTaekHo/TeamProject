package com.example.demo.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@Operation(summary = "상품등록", description = "파라미터로 받은 상품정보를 등록합니다.")
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody ItemDTO dto){
		log.info("상품을 등록합니다.");
		int no= service.register(dto);
		return new ResponseEntity<>(no, HttpStatus.CREATED);
	}
	
//	@Operation(summary = "상품등록", description = "파라미터로 받은 상품정보를 등록합니다.")
//	@GetMapping
//	public ResponseEntity<List<ItemDTO>> getList(){
//		log.info("상품을 등록합니다.");
//		int no= service.register(dto);
//		return new ResponseEntity<>(no, HttpStatus.CREATED);
//	}
	
	
	
	
	

}
