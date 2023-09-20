package org.zerock.mapper;




import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.CommPageDTO;
import org.zerock.domain.CommentVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper bm;
	@Test
	public void testGetList() {
		bm.getList().forEach(x -> log.info(x));
	}
	@Test
	public void testRead() {
		BoardVO vo = bm.read(4L);
		log.info(vo);
	}
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("insertTest");
		vo.setContent("내용삽입테스트");
		vo.setWriter("글삽입테스터");
		bm.insert(vo);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("insertSelectKeyTest");
		vo.setContent("내용삽입테스트");
		vo.setWriter("글삽입테스터");
		bm.insertSelectKey(vo);
		log.info("입력된 글 번호 : " + vo.getBno());
	}
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setTitle("updateTest");
		vo.setContent("내용 수정 테스트");
		vo.setBno(1L);
		bm.update(vo);
	}
	@Test
	public void testDelete() {
		log.info("삭제한 행 수 :" + bm.delete(5L));
	}
	@Test
	public void insertDummy() {
		Random rand = new Random();
		BoardVO vo = new BoardVO();
		int num;
		for(int i = 1; i <= 10; i++) {
			num = rand.nextInt(5)+1;
			vo.setTitle("insertTest");
			vo.setContent("내용삽입테스트"+i);
			vo.setWriter("글삽입테스터"+num);
			bm.insert(vo);
		}
	}
	@Test
	public void testRank() {
		bm.rank().forEach(x->log.info(x));
	}
	@Test
	public void testCount() {
		Criteria cri = new Criteria();
		cri.setType("C");
		cri.setKeyword("테스");
		log.info("전체 글 개수:"+bm.count(new Criteria()));
		log.info("내용에 테스가 들어가는 글 전체 개수"+bm.count(cri));
	}
	
	@Test
	public void testLastBoard() {
		bm.lastBoard().forEach(x->log.info(x));
	}
	@Test
	public void testPostCount() {
		bm.postCount().forEach(x->log.info(x));
	}
	@Test
	public void testReadComm() {
		bm.readComm(2457651L);
	}
	@Test
	public void testInsertComm() {
		CommentVO vo = new CommentVO();
		vo.setBno(2457651L);
		vo.setWriter("맵퍼댓글삽입테스트");
		vo.setText("댓글내용");
		bm.insertComm(vo);
	}
	@Test
	public void testRmComm() {
		bm.rmComm(5L);
	}
	@Test
	public void testGetListWithPaging() {
		Criteria cri = new Criteria();
		cri.setType("C");
		cri.setKeyword("댓글");
		bm.getListWithPaging(cri).forEach(x -> log.info(x));
	}
//	@Test
//	public void testKingUser() {
//		log.info("가장 많은 게시글을 쓴 사람 : " + bm.kingUser());
//	}
}
