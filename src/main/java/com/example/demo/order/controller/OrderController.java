package com.example.demo.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.service.CartService;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.order.service.OrdersService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	CartService cartService;
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/register")
	public void register(String memberId, Model model) {
		MemberDTO memberDTO = memberService.read(memberId);
		List<CartDTO> list = cartService.getList();
		model.addAttribute("cartList", list);
		model.addAttribute("memberDTO", memberDTO);
	}
	
}
