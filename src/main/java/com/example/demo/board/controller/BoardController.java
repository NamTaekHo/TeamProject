package com.example.demo.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
