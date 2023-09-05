package com.example.demo.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.service.CartService;

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
	public void list(Model model) {
		List<CartDTO> list = service.getList();
		model.addAttribute("list", list);
	}
	
	
	

}
