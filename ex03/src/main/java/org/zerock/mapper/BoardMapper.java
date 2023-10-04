package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.BoardVO;
import org.zerock.domain.CommentVO;
import org.zerock.domain.Criteria;
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
	//작성글 수 랭킹 작성자, 작성 글 개수 상위5명
	List<RankVO> rank();
	
	//전체 작성자 글 작성 수
	List<RankVO> rankAll();
	
	//업데이트일자 기준 최근 갱신된 글 5개
	List<BoardVO> lastBoard();
	
	//작성자별 평균 글 작성 수
	Double avgPost();
	
	//시간대별 글 개수 통계(작성일 기준) 00 5 / 1 1
	List<PostAtTimeVO> postCount();
	
	//요일별 작성글 통계
	List<PostAtTimeVO> postCountDay();
	
	
//	//댓글 읽기
//	List<CommentVO> readComm(Long bno);
//	
//	
//	//댓글 작성
//	void insertComm(CommentVO vo);
//	
//	//댓글 삭제
//	int rmComm(Long cno);
//	
//	//전체 댓글
//	Long commCount();
//	
	//전체 글 개수
	Long count(Criteria cri);
	
	//</보너스>
	
	//목록 페이징 - 현재는 무조건 2페이지 출력 (페이지당 10개)
	List<BoardVO> getListWithPaging(Criteria cri);
	
	//글 검색
	
}
