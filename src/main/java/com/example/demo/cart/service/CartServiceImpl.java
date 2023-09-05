package com.example.demo.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.cart.dto.CartDTO;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.entity.Item;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public int register(CartDTO dto) {
		Cart entity = dtoToEntity(dto);
		cartRepository.save(entity);

		return entity.getNo();
	}

	@Override
	public CartDTO read(int cartNo) {
		Optional<Cart> result = cartRepository.findById(cartNo);

		if (result.isPresent()) {
			Cart cart = result.get();
			return entityToDto(cart);
			
		}else {
			
			return null;
		}

	}

	@Override
	public void modify(CartDTO dto) {
		
		Optional<Cart> result = cartRepository.findById(dto.getCartNo());
		
		if(result.isPresent()) {
			Cart entity = result.get();
			
			entity.setCount(dto.getCount());
			
			cartRepository.save(entity);
		}

	}

	@Override
	public void remove(CartDTO dto) {
		Optional<Cart> result = cartRepository.findById(dto.getCartNo());
		
		if(result.isPresent()) {
			Cart entity = result.get();
			cartRepository.delete(entity);
			
		}

	}
	//카트페이지 만들기 9/4 페이지, 리스트 추가
	
//	@Override
//	public Page<CartDTO> getList(int pageNumber) {
//	int pageNum = (pageNumber == 0) ? 0 : pageNumber-1;
//	Pageable pageable = PageRequest.of(pageNum, 5, Sort.by("cartNo").descending());
//	Page<Cart> entityPage= cartRepository.findAll(pageable);
//	Page<CartDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));
//
//	return dtoPage;
//	}
//
	@Override
	public List<CartDTO> getList() {
		List<Cart> result = cartRepository.findAll(); //사용자별 목록조회 호출하도록 변경
		List<CartDTO> dtoList = new ArrayList<>(); 
		dtoList =result.stream()
		.map(entity -> entityToDto(entity))
		.collect(Collectors.toList());
	
		return dtoList;
	}
	
	

	

}
