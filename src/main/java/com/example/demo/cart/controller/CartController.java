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
import com.example.demo.item.service.ItemService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService service;
	
	@Autowired
	private ItemService itemService;
	
	
//	@GetMapping("/cartList")  -- 원본
//	public void list(Model model, Principal principal) {
//		//사용자아이디 꺼내고,          //이건 추후에
//		List<CartDTO> list = service.getList(); //사용자아이디에 따라서 목록조회
//		model.addAttribute("list", list);
//	}
	@GetMapping("/cartList")
	public void list(Model model, Principal principal) {
		//사용자아이디 꺼내고,          //이건 추후에
		String id = principal.getName();
		List<CartDTO> list = service.getList(id); //사용자아이디에 따라서 목록조회
		model.addAttribute("list", list);
		
		
	}
	
	//todo: 등록 
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String registerCart(ItemDTO dto, RedirectAttributes redirectAttributes, Principal principal) { //파라미터 상품번호 수집하기
		
		//등록할 때 필요한 장바구니 데이터는 하나씩 구성하기
		principal.getName();//
		
//		int no = service.register(dto);
		int no = itemService.register(dto);
		redirectAttributes.addFlashAttribute("no",no);
		return "redirect:/item/itemList";
	}
	
	
	//todo: 수정,삭제
	
	//dd
	

}
