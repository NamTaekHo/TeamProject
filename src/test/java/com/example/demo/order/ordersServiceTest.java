package com.example.demo.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;
import com.example.demo.order.dto.OrdersDTO;
import com.example.demo.order.entity.Orders;
import com.example.demo.order.service.OrderService;

@SpringBootTest
public class ordersServiceTest {

	@Autowired
	OrderService service;

	@Test
	public void 데이터등록() {
		for (int i = 0; i < 30; i++) {
			service.register(new OrdersDTO(i, 1, "10aa", null, null, null, null));
		}
	}

	@Test
	public void 데이터조회() {
		OrdersDTO dto = service.read(10);

		System.out.println(dto);
	}
	
	@Test
	public void 데이터목록조회() {
		Page<OrdersDTO> page = service.getList(1);
		List<OrdersDTO> list = page.getContent();
		
		for(OrdersDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 데이터수정() {
		OrdersDTO dto = service.read(10);
		dto.setReceiverName("둘리");
		dto.setReceiverPhone("010-1324-5236");
		dto.setShipAddress("인천광역시 남구 구월동 223-11");
		
		service.modify(dto);
	}
	
	@Test
	public void 데이터삭제() {
		OrdersDTO dto = service.read(13);
		service.remove(dto);
	}

}
