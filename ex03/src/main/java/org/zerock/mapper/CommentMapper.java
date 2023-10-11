package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.ChartVO;
import org.zerock.domain.CommentVO;
import org.zerock.domain.Criteria;

public interface CommentMapper {
	//댓글 읽기
	List<CommentVO> readComm(Long bno);
		
	//댓글 작성
	int insertComm(CommentVO vo);
		
	//댓글 삭제
	int rmComm(Long cno);
		
	//전체 댓글
	Long commCount();
	
	//댓글 수정
	int updateComm(CommentVO vo);
		
	//전체 글 개수
	Long count(Criteria cri);
	
	//댓글추천하기
	int like(Long cno);
	
	//댓글이 있는 게시글 숫자
	Long postHaveComm();
	
	//가장 많은 댓글이 달린 게시글번호
	Long commRank();
	
	//오늘달린 댓글 목록
	List<CommentVO> commToday();
	
	//오늘달린 댓글 갯수, 현재시간
	ChartVO commTodayCount();
	
	//실시간 인기글
	List<BoardVO> getPopular();
	
	CommentVO get(Long cno);
	

}
