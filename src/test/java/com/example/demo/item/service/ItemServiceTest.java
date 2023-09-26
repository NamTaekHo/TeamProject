package com.example.demo.item.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.item.dto.ItemDTO;

@SpringBootTest
public class ItemServiceTest {
	
	@Autowired
	ItemService service;
	
//	@Test
//	public void 상품30개등록() {
//		for(int i=1; i<=30; i++) {
//			service.register(new ItemDTO(i, "yellow jacket", i*20000, null, "new arrival", null, null));
//		}
//	}
	
	@Test
	public void 상품목록조회() {
		Page<ItemDTO> page =service.getList(3);
		List<ItemDTO> list = page.getContent();
		for(ItemDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 상품단건조회_9번() {
		ItemDTO dto = service.read(9);
		System.out.println(dto);
	}
	
	@Test
	public void 상품정보수정_14번() {
		ItemDTO dto =service.read(14);
		dto.setDescription("old stuff");
		dto.setItemName("red jacket");
		
		service.modify(dto);
	}
	
	@Test
	public void 상품삭제_25번() {
		service.remove(25);
	}
	
	@Test
	public void 상품리스트() {
		List<ItemDTO> list = service.newList4();
		System.out.println(list);
		
	}
	
	
	
	
	
	
	
	

}
