package com.example.demo.cart.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
//	@Override
//	public CartDTO read(int cartNo) {
//		Optional<Cart> result = cartRepository.findById(cartNo);
//
//		if (result.isPresent()) {
//			Cart cart = result.get();
//			return entityToDto(cart);
//			
//		}else {
//			
//			return null;
//		}
//
//	}
	@Override
	public void modify(CartDTO dto) {
		
		Optional<Cart> result = cartRepository.findById(dto.getNo());
		
		if(result.isPresent()) {
			Cart entity = result.get();
			
			entity.setCount(dto.getCount());
			
			cartRepository.save(entity);
		}
	}
	@Override
	public void remove(CartDTO dto) {
		Optional<Cart> result = cartRepository.findById(dto.getNo());
		
		if(result.isPresent()) {
			Cart entity = result.get();
			cartRepository.delete(entity);
			
		}
	}
	//카트페이지 만들기 9/4 페이지, 리스트 추가
	
	
	@Override
	public List<CartDTO> getList(String memberId) {
		
		List<Cart> result = cartRepository.findAll();
		List<CartDTO> dtolist = new ArrayList<>();
		for(Cart cart : result) {
			if(cart.getId().getId() == memberId) {
				CartDTO dto = entityToDto(cart);
				dtolist.add(dto);
			}
		}
		
		
//		List<CartDTO> dtoList = new ArrayList<>();
//		dtoList =result.stream()
//		.map(entity -> entityToDto(entity))
//		.collect(Collectors.toList());
	
		return dtolist;
	}
	
	
	
}