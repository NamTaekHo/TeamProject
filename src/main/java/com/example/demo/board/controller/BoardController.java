
package com.example.demo.board.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//게시판 홈
	@GetMapping("/boardList")
	public void list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<BoardDTO> list = service.getList(page);
		model.addAttribute("list", list);
	}
	
	//게시물 등록화면
	@GetMapping("/register")
	public void register() {
		
	}
	
	//게시물 등록
	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes,Principal principal) {
		String memberId = principal.getName();
		dto.setId(memberId);
		int boardNo = service.register(dto);
		redirectAttributes.addFlashAttribute("msg", boardNo);
		return "redirect:/board/boardList";
	}
	
	//게시물 상세페이지
	@GetMapping("/read")
	public void read(int boardNo,@RequestParam(defaultValue = "0") int page, Model model, Principal principal,BoardDTO boardDTO) {//int boardNo,
		String memberId = principal.getName();
		boardDTO.setId(memberId);	
		BoardDTO dto = service.read(boardNo);
		
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		model.addAttribute("memberId",memberId);
	}
	
	
	//게시물 수정페이지
	@GetMapping("/modify")
	public void modify(int boardNo, Model model){
		BoardDTO dto = service.read(boardNo);
		model.addAttribute("dto", dto);
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("boardNo", dto.getBoardNo());
		return "redirect:/board/read";
	}
	
	@PostMapping("/remove")
	public String removePost(int boardNo) {
		service.remove(boardNo);
		return "redirect:/board/boardList";
	}

}

