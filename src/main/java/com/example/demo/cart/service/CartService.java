package com.example.demo.cart.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;
public interface CartService {
	
	int register(CartDTO dto);
	
//	CartDTO read(int cartNo);//id로 읽기?
	
	void modify(CartDTO dto);
	
	void remove(CartDTO dto);
	
	
	//카트페이지 만들기 9/4 페이지, 리스트 추가
	List<CartDTO> getList(String id);
	
	
	
	//DtoToEntity 변환
	
	default Cart dtoToEntity(CartDTO dto) {
		Member member = Member.builder().id(dto.getId()).build();
		Item item = Item.builder().itemNo(dto.getItemNo()).build();
		
		Cart entity = Cart.builder()
				.itemNo(item)
				.id(member)
				.count(dto.getCount())
				.build();
		
		return entity;
	}
	
	//아이템정보 옮겨오기
	//entityToDto 변환
	default CartDTO entityToDto(Cart entity) {
		CartDTO dto = CartDTO.builder()
				.itemNo(entity.getItemNo().getItemNo()) //참고해서
				.itemName(entity.getItemNo().getItemName())
				.price(entity.getItemNo().getPrice())
				.id(entity.getId().getId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.count(entity.getCount())
				.build();
		
		return dto;
	}
}