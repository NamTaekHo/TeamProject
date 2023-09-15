package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.service.ItemService;

@Controller
public class HomeController {

	@Autowired
	private ItemService service;
	
	

	@GetMapping("/")
	public String mainHome(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<ItemDTO> list = service.getList(page);
		model.addAttribute("list",list);
		return "home/main";
		
	
	}

	

	@GetMapping("/customlogin")
	public String customLogin() {
		return "home/login";
	}

}
