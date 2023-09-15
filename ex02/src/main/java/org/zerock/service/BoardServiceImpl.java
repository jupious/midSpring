package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PostAtTimeVO;
import org.zerock.domain.RankVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	
	private BoardMapper bm;

	@Override
	public List<BoardVO> getList() {
		log.info("목록보기 서비스");
		return bm.getList();
	}

	@Override
	public void register(BoardVO vo) {
		log.info("글 작성 서비스");
		bm.insertSelectKey(vo);
		log.info("작성된 글 번호:"+ vo.getBno());
	}

	@Override
	public boolean modify(BoardVO vo) {
		log.info("글 수정 서비스");
		return bm.update(vo) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("글 삭제 서비스");
		return bm.delete(bno) == 1 ? true : false;
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("글 상세보기 서비스");
		return bm.read(bno);
	}

	@Override
	public Long count() {
		log.info("게시글 숫자 서비스");
		return bm.count();
	}

	@Override
	public List<RankVO> getRank() {	
		log.info("작성 글수 상위5명 서비스");
		return bm.rank();
	}

	@Override
	public List<BoardVO> latestBoard() {
		log.info("가장 최근에 작성된 게시글 5개");
		return bm.lastBoard();
	}

	@Override
	public List<PostAtTimeVO> postCount() {
		log.info("시간별 작성 글 통계");
		return bm.postCount();
	}

}
