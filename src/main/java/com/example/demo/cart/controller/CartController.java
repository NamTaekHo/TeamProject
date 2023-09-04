package com.example.demo.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void read(@RequestParam(defaultValue = "0")int read, Model model) {
		CartDTO itemRead = service.read(read);
		model.addAttribute("itemRead", itemRead);
	}
	
	
	
	
	

}
