package org.zerock.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImplTests {
	@Autowired
	private BoardService bs;

	@Test
	public void testGetList() {
		log.info("목록보기 서비스");
		Criteria cri = new Criteria();
		bs.getList(cri).forEach(x -> log.info(x));
	}

	@Test
	public void testRegister() {
		log.info("글 작성 서비스");
		BoardVO vo = new BoardVO();
		vo.setTitle("registerTestwithKey");
		vo.setContent("내용삽입테스트");
		vo.setWriter("글삽입테스터");
		bs.register(vo);
	}

	@Test 
	public void testModify() {
		log.info("글 수정 서비스");
		BoardVO vo = new BoardVO();
		vo.setTitle("modifyTest");
		vo.setContent("내용 수정 테스트");
		vo.setBno(33L);
		bs.modify(vo);
	}

	@Test 
	public void testRemove() {
		log.info("글 삭제 서비스");
		bs.remove(39L);
	}

	@Test
	public void testGet() {
		log.info("글 상세보기 서비스");
		BoardVO vo = bs.get(42L);
		log.info(vo);
	}
	
	@Test
	public void testCount() {
		log.info("게시글 숫자 서비스 : " + bs.count());
		
	}

	@Test
	public void testGetRank() {	
		log.info("작성 글수 상위5명 서비스");
		bs.getRank().forEach(x -> log.info(x));
	}

	@Test
	public void testLatestBoard() {
		log.info("가장 최근에 작성된 게시글 5개");
		bs.latestBoard().forEach(x -> log.info(x));;
	}

	@Test
	public void testPostCount() {
		log.info("시간별 작성 글 통계");
		bs.postCount().forEach(x -> log.info(x));;
	}
}
