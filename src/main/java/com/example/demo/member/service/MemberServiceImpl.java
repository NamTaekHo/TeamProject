package com.example.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.service.BoardService;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//비밀번호 수정 시간남으면 하는걸로 일단 주석처리 함

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BoardRepository boardRepository;



	@Override // 게시판 페이지
	public Page<MemberDTO> getlist(int page) {
		int pageNum = (page == 0) ? 0 : page - 1;
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("id").descending());
		Page<Member> entityPage = memberRepository.findAll(pageable);
		Page<MemberDTO> dtoPage = entityPage.map(entity -> entityToDto(entity));

		return dtoPage;
	}

	@Override
	public MemberDTO read(String id) {// 상세조회
		Optional<Member> result = memberRepository.findById(id);
		if (result.isPresent()) {
			Member member = result.get();
			return entityToDto(member);
		} else {
			return null;
		}

	}

	@Override
	public MemberDTO myPage(String id) { // 마이페이지
		Optional<Member> result = memberRepository.findById(id);
		if (result.isPresent()) {

			Member member = result.get();
			return entityToDto(member);

		} else {
			return null;
		}

	}

	@Override
	public void modify(MemberDTO dto) {// 회원정보 수정
		Optional<Member> result = memberRepository.findById(dto.getId());
		if (result.isPresent()) {
			Member entity = result.get();

			entity.setAddress(dto.getAddress());
			entity.setEmail(dto.getEmail());
//			entity.setPassword(dto.getPassword());
			entity.setPNumber(dto.getPNumber());

			memberRepository.save(entity);
		}

	}

	@Override
	public boolean register(MemberDTO dto) {// 회원 등록
		String id = dto.getId();// 아이디 중복 체크
		MemberDTO getDto = read(id);// 상세조회
		if (getDto != null) {
			System.out.println("사용중인 아이디입니다.");
			return false;
		}
		Member entity = DtoToEntity(dto);

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();// 패스워드를 암호화
		String hashpassword = passwordEncoder.encode(entity.getPassword());// 암호화 한 패스워드를 서버에 저장
		entity.setPassword(hashpassword);
		memberRepository.save(entity);

		return true;
	}

	@Override
	public void delete(MemberDTO dto) {
		Optional<Member> result = memberRepository.findById(dto.getId());
		Member entity = result.get();
		if (result.isPresent()) {
			boardRepository.deleteBoardByMember(entity);
			memberRepository.delete(entity);

		}
	}

//	@Override
//	public String remove(String id) {
//		Optional<Member> result = memberRepository.findById(id);
//		Member member = result.get();
//		if(result.isPresent()) {
//			List<Board> boardList = boardRepository.getBoardByMember(member);
//			for(Board b : boardList) {
//				boardService.remove(b.getBoardNo());
//			}
//			boardRepository.deleteBoardByMember(member);
//			memberRepository.deleteById(id);
//			return "1";
//		}else {
//			return "0";
//		}
//		
//	}




}
