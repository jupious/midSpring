package edu.kwak.mapper;

import java.util.List;

import edu.kwak.domain.MemberVO;
import edu.kwak.domain.PostVO;

public interface BoardMapper {
	
	//회원가입
	int signUp(MemberVO vo);
	
	//로그인
	Integer login(String id);
	
	//전체글 보기
	List<PostVO> list();
	
	//전체글 페이징
	
	//글 읽기
	PostVO read(Long pno);
	
	//글쓰고 번호반환
	void insert(PostVO vo);
	
	//글 수정
	int update(PostVO vo);
	
	//글 삭제
	int deletePost(Long pno);
	
	//글 검색
	
}
