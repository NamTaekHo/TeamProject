package com.example.demo.cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.cart.service.CartService;
import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
@SpringBootTest
public class CartRepositoryTest {
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void 데이터등록() {
		Optional<Member> result1 = memberRepository.findById("ww");
		Member m = result1.get();
		Optional<Item> result2 = itemRepository.findById(1);
		Optional<Item> result3 = itemRepository.findById(1);
		Item i1 = result2.get();
		Item i2 = result3.get();
		
		List<Cart> list = new ArrayList<>();
		
		
		
		list.add(new Cart(0, i2, m, 2));
		list.add(new Cart(0, i1, m, 1));

		
		cartRepository.saveAll(list);
		
		
	}
	
//	@Test
//	public void 쿼리테스트1_dto로표시() {
//		List<Cart> list = cartRepository.selectCartByID("나무라코");
//		List<CartDTO> dtolist = new ArrayList<>();
//		for(int i = 0; i<list.size(); i++) {
//			Cart c =  list.get(i);
//			CartDTO dto = cartService.entityToDto(c);
//			dtolist.add(dto);
//		}
//		System.out.println(dtolist);
//		
//	}
	
//	@Test
//	public void 쿼리테스트2 () {
//		Optional<Member> result = memberRepository.findById("나무라코");
//		Member member = result.get();
//		List<Cart> list = cartRepository.selectCartByID(member);
//		System.out.println(list);
//	}
	
//	@Test
//	public void 쿼리테스트3() {
//		List<Cart> list = cartRepository.getCartByMemberId("나무라코");
//		System.out.println(list);
//	}
	
	@Test
	public void 쿼리테스트4() {
		List<Cart> list = cartRepository.getCartByMemberId("나무라코");
		for(Cart cart : list) {
			System.out.println(cart);
		}
//		System.out.println(list);
	}
}