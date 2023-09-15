package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.BoardVO;
import org.zerock.domain.PostAtTimeVO;
import org.zerock.domain.RankVO;

public interface BoardMapper {

	//글 목록 리스트
	List<BoardVO> getList();
	
	//글 상세보기
	BoardVO read(Long bno);
	
	//글 작성
	void insert(BoardVO vo);
	
	//작성된 글 번호 확인
	void insertSelectKey(BoardVO vo);
	
	//글 수정
	int update(BoardVO vo);
	
	//글 삭제
	int delete(Long bno);
	
	//<보너스>
	//작성글 수 랭킹 작성자, 작성 글 개수
	List<RankVO> rank();
	
	//업데이트일자 기준 최근 갱신된 글 5개
	List<BoardVO> lastBoard();
	
	//시간대별 글 개수 통계(작성일 기준) 00 5 / 1 1
	List<PostAtTimeVO> postCount();
	
	//전체 글 개수
	Long count();
	
	//</보너스>
	
	//목록 페이징
	
	//글 검색
	
}
