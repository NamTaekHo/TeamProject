package com.example.demo.cart.service;

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
		Cart entity = dtoToEntity(dto);
		cartRepository.save(entity);

		return entity.getCartNo();
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

}
