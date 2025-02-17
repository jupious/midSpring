package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ChartVO;
import org.zerock.domain.CommentVO;
import org.zerock.mapper.CommentMapper;
import org.springframework.web.util.HtmlUtils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	private CommentMapper cm;

	@Override
	public List<CommentVO> getComm(Long bno) {
		log.info("댓글 읽기~~~~~~~~~~~");
		return cm.readComm(bno);
	}

	@Override
	public boolean regComm(CommentVO vo) {
		log.info("댓글 쓰기~~~~~~~~~~~");
		String tag = vo.getText();
		String esc = HtmlUtils.htmlEscape(tag);
		vo.setText(esc);
		tag = vo.getWriter();
		esc = HtmlUtils.htmlEscape(tag);
		vo.setWriter(esc);
		return cm.insertComm(vo) == 1 ? true : false;
	}

	@Override
	public boolean delComm(Long cno) {
		log.info("댓글 지우기~~~~~~~~~~~");
		return cm.rmComm(cno) == 1 ? true : false;
	}

	@Override
	public Long commCount() {
		log.info("전체 댓글 수~~~~~~~~~");
		return cm.commCount();
	}

	@Override
	public boolean upComm(CommentVO vo) {
		log.info("댓글 수정~~~~~~~~~~~~~~~");
		return cm.updateComm(vo) == 1 ? true : false;
	}

	@Override
	public CommentVO get(Long cno) {
		return cm.get(cno);
	}

	@Override
	public boolean likeComm(Long cno) {
		return cm.like(cno) == 1 ? true : false ;
	}
	
	@Override
	public String postHaveComm() {
		log.info("댓글이 있는 게시글 수~~~~~~~~~~~~~~~~");
		return cm.postHaveComm()+"";
	}
	
	@Override
	public Long commRank() {
		log.info("가장 댓글이 많은 글 수~~~~~~~~~~~");
		return cm.commRank();
	}

	@Override
	public List<CommentVO> commToday() {
		log.info("오늘 달린 댓글~~~~~~~~~~~~~~~~~~~~");
		return cm.commToday();
	}

	@Override
	public ChartVO commTodayCount() {
		log.info("오늘 달린 댓글 수~~~~~~~~~~~~~~~");
		return cm.commTodayCount();
	}

	@Override
	public List<BoardVO> getPopular() {
		return cm.getPopular();
	}

	@Override
	public int deleteCommentOnPost(Long bno) {
		return cm.deleteCommOnPost(bno);
	}
}
