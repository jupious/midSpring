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
	
	//19. 댓글이 있는 게시글 수
	String postHaveComm();
	
	//14. 가장 많은 댓글이 달린 게시글번호
	Long commRank();

	
	CommentVO get(Long cno);
}
