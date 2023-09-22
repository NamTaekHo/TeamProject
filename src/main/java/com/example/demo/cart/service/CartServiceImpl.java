package com.example.demo.cart.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public int register(CartDTO dto) {
		
		//장바구니에 로그인한 아이디 set		
		//데이터베이스 저장		
		Cart entity = dtoToEntity(dto);
		cartRepository.save(entity);
		return entity.getNo();
	}
	
	
	
	@Override 
	public void remove(int no) {
		Optional<Cart> result = cartRepository.findById(no);
		
		if(result.isPresent()) {
			
			cartRepository.deleteById(no);			
		}
	}
	//카트페이지 만들기 9/4 페이지, 리스트 추가
	
	
	@Override
	public List<CartDTO> getList(String memberId) {
		
		List<Cart> result = cartRepository.findAll();
		List<CartDTO> dtolist = new ArrayList<>();
		for(Cart cart : result) {
			if(cart.getId().getId().equals(memberId)) {
				CartDTO dto = entityToDto(cart);
				dtolist.add(dto);
			}
		}
		
		return dtolist;
	}		
	
}