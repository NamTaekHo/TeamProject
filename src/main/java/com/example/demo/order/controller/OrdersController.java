package com.example.demo.order.controller;

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
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.service.OrdersService;
import com.example.demo.ordersItem.dto.OrdersItemDTO;
import com.example.demo.ordersItem.service.OrdersItemService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	CartService cartService;
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	OrdersItemService ordersItemService;
	
	// 주문 내역(리스트)
	@GetMapping("/ordersList")
	public void list(@RequestParam(defaultValue = "0") int page, Principal principal, Model model) {
		String memberId = principal.getName();
		Page<OrdersDTO> list = ordersService.getList(page, memberId);
		model.addAttribute("list", list);
		
	}
	
	// 주문 상세 조회
	// 주문번호로 주문상품 찾는 쿼리 생성 - 찾아서 model객체에 담아서 뷰단에 전달.
	@GetMapping("/read")
	public void read(@RequestParam int orderNo, @RequestParam(defaultValue = "0") int page, Model model, Principal principal) {
		String memberId = principal.getName();		
		OrdersDTO ordersDTO = ordersService.read(orderNo);
		ordersDTO.setId(memberId);
		List<OrdersItemDTO> list = ordersItemService.getList(orderNo);
		
		model.addAttribute("oIDTOList", list);
		model.addAttribute("ordersDTO", ordersDTO);
		model.addAttribute("page", page);
		model.addAttribute("memberId", memberId);
	}
	
	// 주문 등록화면(결제 전)
	@GetMapping("/register")
	public void register(Principal principal, Model model) {
		String memberId = principal.getName();
		MemberDTO memberDTO = memberService.read(memberId);
		List<CartDTO> list = cartService.getList(memberId);
		model.addAttribute("cartList", list);
		model.addAttribute("memberDTO", memberDTO);
	}
	
	// 결제 후 등록
	@PostMapping("/register")
	public String registerOrder(OrdersDTO dto, RedirectAttributes redirectAttributes, Principal principal) {
		String memberId = principal.getName();
		dto.setId(memberId);
		int orderNo = ordersService.register(memberId, dto);
		redirectAttributes.addFlashAttribute("msg", orderNo);
		
		return "redirect:/orders/ordersList";
	}
	
	// 주문내역 삭제
	@PostMapping("/remove")
	public String removeOrder(int orderNo) {
		ordersService.remove(orderNo);
		return "redirect:/orders/ordersList";
	}
	
}
