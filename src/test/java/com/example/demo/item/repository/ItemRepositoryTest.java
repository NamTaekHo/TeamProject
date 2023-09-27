package com.example.demo.item.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;

@SpringBootTest
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository repository;
	
	
//	@Test
//	public void 상품등록() {
//		List<Item> list = new ArrayList<>();
//		
//		Item item0 = new Item(0, "브라운재", 49000, "ㅁㅁ", "가을철");
//		Item item1 = new Item(0, "브라운킷", 4, "ㅁㅁ", "가을철 가벼");
//		Item item2 = new Item(0, "브라재킷", 49, "ㅁㅁ", "가을철 가벼운 브");
//		Item item3 = new Item(0, "운재킷", 490, "ㅁㅁ", "가을철 가벼운 브라운");
//		Item item4 = new Item(0, "재킷", 4900, "ㅁㅁ", "가을철 가벼운 브라운 재");
//		
//
//		
//		List<Item> itemList = repository.saveAll(List.of(item0,item1,item2,item3,item4));
//		
//		Assertions.assertThat(itemList).hasSize(5);
//	}

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
	
	@Test
	public void 쿼리테스트() {
		List<Item> list = repository.getItemByCategory("shoes");
		for(Item i : list) {
			System.out.println(i);
		}
	}

	

}
