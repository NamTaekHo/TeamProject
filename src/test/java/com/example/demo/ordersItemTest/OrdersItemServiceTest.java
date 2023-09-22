package com.example.demo.ordersItemTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.ordersItem.dto.OrdersItemDTO;
import com.example.demo.ordersItem.service.OrdersItemService;

@SpringBootTest
public class OrdersItemServiceTest {

	@Autowired
	OrdersItemService ordersItemService;
	
	@Test
	public void 주문번호로아이템목록조회() {
		List<OrdersItemDTO> list = ordersItemService.getList(3);
		System.out.println(list);
	}
}
