package com.example.demo.item.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.item.dto.ItemDTO;
import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository repository;

	@Override
	public int register(ItemDTO dto) {
		Item entity = dtoToEntity(dto);
		repository.save(entity);		

		return entity.getItemNo();
	}

	@Override
	public List<ItemDTO> getList() {
		List<Item> entityList = repository.findAll();
		List<ItemDTO> dtoList = entityList.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());
		
		return dtoList;
	}

	@Override
	public ItemDTO read(int itemNo) {
		
		Optional<Item> result = repository.findById(itemNo);
        if(result.isPresent()) {
        	Item board =  result.get();
        	return entityToDto(board);
        } else {
        	return null;
        }
	}

	@Override
	public void modify(ItemDTO dto) {
		Optional<Item> result = repository.findById(dto.getItemNo());
		if(result.isPresent()) {
			Item entity =result.get();
			entity.setItemName(dto.getItemName());
			entity.setPrice(dto.getPrice());
			entity.setImage(dto.getImage());
			entity.setDescription(dto.getDescription());
			
			repository.save(entity);
		}
		
		
	}

	@Override
	public void remove(int itemNo) {
		repository.deleteById(itemNo);
	}

	@Override
	public Page<ItemDTO> getList(int pageNumber) {
		int pageNum = (pageNumber == 0) ? 0 : pageNumber-1;
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("itemNo").descending());
		Page<Item> entityPage= repository.findAll(pageable);
		Page<ItemDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));
		
		return dtoPage;
	}

}
