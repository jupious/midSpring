package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//글 목록 리스트
	List<BoardVO> getList();
	
	//글 상세보기
	BoardVO read(Long bno);
	
	//글 작성
	void insert(BoardVO vo);
	
	//글 수정
	int update(BoardVO vo);
	
	//글 삭제
	int delete(Long bno);
	
	//보너스(가장 많은 글을 작성한 사용자 이름)
	String kingUser();
	
	//목록 페이징
	
	//글 검색
	
}
