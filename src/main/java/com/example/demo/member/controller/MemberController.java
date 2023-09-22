package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@Controller
//회원가입시 스크립트 적용하기 2023/09/11
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/member/memberlist") // 회원목록 페이지
	public void list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<MemberDTO> list = service.getlist(page);
		model.addAttribute("list", list);

	}

	@GetMapping("/member/modify") // 회원 수정페이지
	public void modify(String id, Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
	}

	@PostMapping("/member/modify") // 회원 수정 등록
	public String modifyPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("id", dto.getId());
		return "redirect:/member/read";
	}

	@PostMapping("/member/remove") // 회원 삭제
	public String removePost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		service.delete(dto);
		redirectAttributes.addAttribute("id", dto.getId());
		return "redirect:/member/memberlist";
	}
	

	@GetMapping("/register") // 회원등록 페이지
	public String register() {
		return "member/register";
	}

	@PostMapping("/register") // 회원 등록
	public String registerPost(MemberDTO dto, RedirectAttributes attributes) {
		boolean isSuccess = service.register(dto);
		if (isSuccess) {
//			attributes.addFlashAttribute("msg2","회원가입을 축하드립니다.");
			return "redirect:/";
		} else {
			attributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/register";
		}
	}

	@GetMapping("/member/read") // 상세페이지
	public void read(String id, @RequestParam(defaultValue = "0") int page, Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}
	
	@GetMapping("/member/info") // 내정보페이지
	public void info(String id, Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
	}

}
