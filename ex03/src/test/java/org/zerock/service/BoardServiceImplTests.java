package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImplTests {
	@Autowired
	private BoardService bs;
	
//	@Test
//	public void testCommCounter() {
//		bs.commCount(2457651L);
//	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		bs.getList(cri).forEach(x -> log.info(x));
		
	}
	
//	@Test
//	public void testPostHaveCOmm() {
//		bs.postHaveComm();
//	}
	
//	@Test
//	public void testCommRank() {
//		bs.commRank();
//	}
}
