package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentMapperTests {
	@Autowired
	private CommentMapper cm;
	
	@Test
	public void testCommToday() {
		cm.commToday();
	}
	@Test
	public void testCommTodayCount() {
		cm.commTodayCount();
	}
	@Test
	public void testGetPopular() {
		cm.getPopular();
	}
	@Test
	public void testDCP() {
		cm.deleteCommOnPost(2457642L);
	}
}
