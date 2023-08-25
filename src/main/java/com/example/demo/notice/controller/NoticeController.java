package com.example.demo.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.notice.dto.NoticeDTO;
import com.example.demo.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//공지 홈
	@GetMapping("/noticeList")
	public void list(@RequestParam(defaultValue = "0")int page, Model model) {
		Page<NoticeDTO> list = service.getList(page);
		model.addAttribute("list",list);
	}
	
	//공지 등록화면
	@GetMapping("/register")
	public void register() {
		
	}
	
	//공지 등록
	@PostMapping("/register")
	public String registerNotice(NoticeDTO dto, RedirectAttributes redirectAttributes) {
		int no = service.register(dto);
		redirectAttributes.addFlashAttribute("no", no);
		return "redirect:/notice/noticeList";
	}
	
	//공지 상세페이지
	@GetMapping("/read")
	public void read(int no, @RequestParam(defaultValue = "0")int page, Model model) {
		NoticeDTO dto=service.read(no);
		model.addAttribute("dto", dto);
		model.addAttribute("page",page);
	}
	
	//공지 수정페이지
	@GetMapping("/modify")
	public void modify(int no, Model model) {
		NoticeDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}
	
	//공지 수정하기
	@PostMapping("/modify")
	public String modifyNotice(NoticeDTO dto, RedirectAttributes redirectAttributes) {
	service.modify(dto);
	redirectAttributes.addAttribute("no", dto.getNo());
	return "redirect:/notice/read";
	}
	
	@PostMapping("/remove")
	public String removeNotice(int no) {
	service.remove(no);
	return "redirect:/notice/noticeList";
	}	

}
