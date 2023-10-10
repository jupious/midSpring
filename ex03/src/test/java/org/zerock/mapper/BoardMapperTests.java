package org.zerock.mapper;

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
public class BoardMapperTests {
	@Autowired
	private BoardMapper bm;
	
//	@Test
//	public void testCommPerPost() {
//		log.info(bm.commPerPost(2457651L));
//	}
	
//	@Test
//	public void testPostHaveComm() {
//		bm.postHaveComm();
//	}
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria();
		bm.getListWithPaging(cri);
	}
	
//	@Test
//	public void testCommRank() {
//		bm.commRank();
//	}
}
