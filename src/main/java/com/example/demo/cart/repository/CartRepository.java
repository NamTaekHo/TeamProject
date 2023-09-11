package com.example.demo.cart.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.cart.entity.Cart;
//@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	//사용자 아이디별로 목록조회 메소드 추가 -> 단위테스트 확인
	//1.순수한 sql 만들어서 디비버 테스트
	//2.쿼리메소드 다시 작성해서 단위테스트로 진행 (스프링 jpa 피피티)
//	@Query(value = "select * from cart c where c.id_id  = :id", nativeQuery = true)
//	List<Cart> selectCartByID(@Param("id") Member memberId);
//	
	@Query("select c from Cart c where c.id.id = :memberId")
	List<Cart> getCartByMemberId(@Param("memberId") String memberId);
}