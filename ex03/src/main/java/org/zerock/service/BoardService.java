package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.CommentVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PostAtTimeVO;
import org.zerock.domain.RankVO;

public interface BoardService {
	//사용자 관점의 서비스
	
	//1. 글 목록
	List<BoardVO> getList(Criteria cri);
	
	//2. 글 작성
	void register(BoardVO vo);
	
	//3. 글 수정
	boolean modify(BoardVO vo);
	
	//4. 글 삭제
	boolean remove(Long bno);
	
	//5. 글 상세보기
	BoardVO get(Long bno);
	
	//6. 전체 글 수
	Long count(Criteria cri);
	
	//7. 작성글 수 랭킹 작성자, 작성 글 개수
	List<RankVO> getRank();
	
	//8. 업데이트일자 기준 최근 갱신된 글 5개
	List<BoardVO> latestBoard();
	
	//9. 시간대별 글 개수 통계(작성일 기준) 00 5 / 1 1
	List<PostAtTimeVO> postCount();
	
	//10. 작성글 수 랭킹 전체
	List<RankVO> getRankAll();
	
	//11. 평균 글 작성수
	double getAvg();
	
	//12. 작성글수 요일통계
	List<PostAtTimeVO> postCountDay();
	
	



}
