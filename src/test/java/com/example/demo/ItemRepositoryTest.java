package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;

@SpringBootTest
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository repository;
	
	
	@Test
	public void 상품등록() {
		Item item = new Item(1, "브라운재킷", 49000, "ㅁㅁ", "가을철 가벼운 브라운 재킷");
		repository.save(item);
	}

	@Test
	public void 상품목록조회() {
		List<Item> list = repository.findAll();
		for(Item item : list) {
			System.out.println(item);
		}
	}
	
	@Test
	public void 상품단건조회() {
		Optional<Item> result = repository.findById(2);
		if(result.isPresent()) {
			Item item = result.get();
			System.out.println(item);
		}else {
			System.out.println("등록된 상품이 없습니다.");
		}
	}

	@Test
	public void 상품정보수정() {
		Optional<Item> result = repository.findById(2);
		Item item = result.get();
		item.setItemName("Brown Jacket");
		item.setPrice(89000);
		repository.save(item);
	}
	
	@Test
	public void 상품삭제() {
		repository.deleteById(2);
	}

	

}
