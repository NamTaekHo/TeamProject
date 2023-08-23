package com.example.demo.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@Operation(summary = "상품등록", description = "파라미터로 받은 상품정보를 등록합니다.")
	@PostMapping
	public ResponseEntity<Integer> register(@RequestBody ItemDTO dto){
		log.info("상품을 등록합니다.");
		int itemNo= service.register(dto);
		return new ResponseEntity<>(itemNo, HttpStatus.CREATED);
	}
	
	@Operation(summary = "상품목록조회", description = "모든 상품정보를 조회합니다.")
	@GetMapping
	public ResponseEntity<List<ItemDTO>> getList(){
		log.info("상품 목록을 조회합니다.");
		List<ItemDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@Operation(summary = "상품 상세조회", description = "파라미터로 받은 상품정보로 교체합니다.")
	@GetMapping("/{itemNo}")
	public ResponseEntity<ItemDTO> read(@PathVariable("itemNo") int itemNo){
		log.info("상품을 상세 조회합니다.");
		ItemDTO dto = service.read(itemNo);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@Operation(summary = "상품 정보수정", description = "파라미터로 받은 상품번호로 상품정보를 조회합니다.")
	@PutMapping
	public ResponseEntity modify(@RequestBody ItemDTO dto) {
		log.info("상품 정보를 수정합니다.");
		service.modify(dto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);				
	}
	
	@Operation(summary = "상품 정보삭제", description = "파라미터로 받은 상품번호로 해당상품을 삭제합니다.")
	@DeleteMapping("/{itemNo}")
	public ResponseEntity remove(@PathVariable("itemNo") int itemNo) {
		log.info("해당 상품을 삭제합니다.");
		service.remove(itemNo);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	

}
