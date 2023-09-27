package com.example.demo.cart.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.service.CartService;
import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.entity.Item;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;	
	
	@Autowired
	private MemberService memberService;
	
	

	@GetMapping("/cartList")
	public void list(Model model, Principal principal) {
		//사용자아이디 꺼내고,          //이건 추후에
		String memberId = principal.getName();
		List<CartDTO> list = cartService.getList(memberId); //사용자아이디에 따라서 목록조회
		model.addAttribute("list", list);		
		
	}
	
			
	//장바구니 등록
	@GetMapping("/register/{itemNo}") 
	public ResponseEntity<Integer> registerCart(@PathVariable int itemNo, Principal principal) { 
		
		//등록할 때 필요한 장바구니 데이터는 하나씩 구성하기
		String memberId =principal.getName();
		memberService.read(memberId);		 		
		
		CartDTO dto = new CartDTO();
		dto.setItemNo(itemNo);
		dto.setId(memberId);		
		
		int cartRegister=cartService.register(dto);
		
		return new ResponseEntity<>(cartRegister, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/remove")
	public ResponseEntity<Boolean> removeCart(@RequestParam("no") int no) {
		cartService.remove(no);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PostMapping("/modify")
	public String modifyCount(CartDTO dto) {
		cartService.modify(dto);
		return "redirect:/cart/cartList";
	}	
	
}
