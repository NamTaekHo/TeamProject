package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.service.ItemService;

@Controller
public class HomeController {

	@Autowired
	private ItemService service;
	
	@GetMapping("/")
	public String home(Model model) {
		List<ItemDTO> desc = service.newList4();
		List<ItemDTO> asc = service.List4();
		model.addAttribute("itemDescList", desc);
		model.addAttribute("itemAscList", asc);
		return "home/main";
	}

	@GetMapping("/customlogin")
	public String customLogin() {
		return "home/login";
	}

}
