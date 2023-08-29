package com.example.demo.member.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.service.MemberService;

@Controller
//@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/memberlist")
	public void list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<MemberDTO> list = service.getlist(page);
		model.addAttribute("list", list);
	}
	
//	@GetMapping("/read")
//	public void read(String id, @RequestParam(defaultValue = "0") int page, Model model) {
//		MemberDTO dto = service.read(id);
//		
//		model.addAttribute("dto",dto);
//		model.addAttribute("page", page);
//	}
	
	@GetMapping("/modify")
	public void modify(String id, Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
	}
	
	@PostMapping("/modify")
	public String modifyPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("id", dto.getId());
		return "redirect:/member/read";
	}
	
	@PostMapping("/remove")
	public String removePost(MemberDTO dto,RedirectAttributes redirectAttributes) {
		service.delete(dto);
		redirectAttributes.addAttribute("id",dto.getId());
		return "redirect:/member/memberlist";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO dto, RedirectAttributes attributes) {
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
			return "redirect:/";
		}else {
			attributes.addFlashAttribute("msg","아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/register";
			
		}
	}
	
	@GetMapping("/member/read")
	public void read(String id, @RequestParam(defaultValue = "0") int page , Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto",dto);
		model.addAttribute("page",page);
	}

}
