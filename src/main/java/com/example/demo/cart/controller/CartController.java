package com.example.demo.cart.controller;

import java.security.Principal;
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

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.service.CartService;
import com.example.demo.item.dto.ItemDTO;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService service;
	
	
	
	@GetMapping("/cartList")
//	public void list(@RequestParam(defaultValue = "0")int page, Model model) {
//		Page<CartDTO> list = service.getList(page);
//		model.addAttribute("list", list);
//	}
	public void list(Model model, Principal principal) {
		//사용자아이디 꺼내고, 
		List<CartDTO> list = service.getList(); //사용자아이디에 따라서 목록조회
		model.addAttribute("list", list);
	}
	
	//todo: 등록 
	
	
	//todo: 수정,삭제
	
	
	

}
