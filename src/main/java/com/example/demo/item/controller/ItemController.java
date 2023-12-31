package com.example.demo.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService service;

	//상품 홈
	@GetMapping("/itemList")
	public void list(@RequestParam(defaultValue = "0")int page, Model model) {
		Page<ItemDTO> list = service.getList(page);
		model.addAttribute("list",list);
	}

	//상품 등록화면
	@GetMapping("/register")
	public void register(){
	
	}
	
	
	//상품 등록
	@PostMapping("/register")
	public String registerItem(ItemDTO dto, RedirectAttributes redirectAttributes){
		int itemNo = service.register(dto);
		redirectAttributes.addFlashAttribute("itemNo", itemNo);
		return "redirect:/item/itemList";
	}
	
	
	//상품 상세페이지
	@GetMapping("/read")
	public void read(int itemNo, @RequestParam(defaultValue = "0")int page, Model model) {
		ItemDTO dto= service.read(itemNo);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}
	
	//상품 수정페이지
	@GetMapping("/modify")
	public void modify(int itemNo, Model model) {
		ItemDTO dto=service.read(itemNo);
		model.addAttribute("dto", dto);
	}
	
	//상품 수정하기
	@PostMapping("/modify")
	public String modifyItem(ItemDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("itemNo", dto.getItemNo());
		return "redirect:/item/read";
	}
	
	
	//상품 삭제하기
	@PostMapping("/remove")
	public String removeItem(int itemNo) {
		service.remove(itemNo);
		return "redirect:/item/itemList";
	}
	
	// top
	@GetMapping("top")
	public void getTop(Model model) {
		List<ItemDTO> list = service.getTop();
		model.addAttribute("topList", list);
	}
	
	@GetMapping("pants")
	public void getPants(Model model) {
		List<ItemDTO> list = service.getPants();
		model.addAttribute("pantsList", list);
	}
	
	@GetMapping("shoes")
	public void getShoes(Model model) {
		List<ItemDTO> list = service.getShoes();
		model.addAttribute("shoesList", list);
	}
	

} 