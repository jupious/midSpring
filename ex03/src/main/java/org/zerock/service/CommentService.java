package org.zerock.service;

import java.util.List;

import org.zerock.domain.CommentVO;

public interface CommentService {
	
	//13. 댓글읽기
	List<CommentVO> getComm(Long bno);
	
	//14. 댓글 쓰기
	boolean regComm(CommentVO vo);
	
	//15. 댓글 삭제
	boolean delComm(Long cno);
	
	//16. 댓글 수정
	boolean upComm(CommentVO vo);
	
	//17. 전체 댓글 갯수
	Long commCount();
	
	//18. 댓글좋아요
	boolean likeComm(Long cno);
	
	CommentVO get(Long cno);
}
