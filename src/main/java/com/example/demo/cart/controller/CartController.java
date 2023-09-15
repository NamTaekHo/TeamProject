package com.example.demo.cart.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.service.CartService;
import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.service.ItemService;
import com.example.demo.member.service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private MemberService memberService;
	
	
//	@GetMapping("/cartList")  -- 원본
//	public void list(Model model, Principal principal) {
//		//사용자아이디 꺼내고,          //이건 추후에
//		List<CartDTO> list = service.getList(); //사용자아이디에 따라서 목록조회
//		model.addAttribute("list", list);
//	}
	@GetMapping("/cartList")
	public void list(Model model, Principal principal) {
		//사용자아이디 꺼내고,          //이건 추후에
		String memberId = principal.getName();
		List<CartDTO> list = cartService.getList(memberId); //사용자아이디에 따라서 목록조회
		model.addAttribute("list", list);
		
		
	}
	
	//todo: 등록 
	//아이템의 상품번호를 받아서 등록으로 넘겨준다?
	//-> 받은 상품번호를 화면에 뿌려준다
	//-> 화면에 상품의 필요부분을 구성(상품이름, 가격, 갯수 등)
//	@PostMapping("/register2") //만들어보기
//	public String registerCart(ItemDTO dto, RedirectAttributes redirectAttributes) { //파라미터 상품번호 수집하기
//		
//		int no = itemService.read(dto);
//		
//		
//	}
	
	
	
	
	
	@PostMapping("/register")
	public String registerCart(int cartNo, RedirectAttributes redirectAttributes, Principal principal) { //파라미터 상품번호 수집하기
		
		//등록할 때 필요한 장바구니 데이터는 하나씩 구성하기
		String memberId =principal.getName();//
		memberService.read(memberId);
		int no = cartNo;
		redirectAttributes.addFlashAttribute("no",no);
		return "redirect:/item/itemList";
	}
	
	
	@PostMapping("/modify")
	public String modifyCart() {
		return null;
	}
	
	@PostMapping("/remove")
	public String removeCart(int no) {
		
		return "redirect:/cart/cartList";
	}
	
	//todo: 수정,삭제
	
	//dd
	
	
}
