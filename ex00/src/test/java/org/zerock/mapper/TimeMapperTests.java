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
public class TimeMapperTests {
	
	@Autowired
	private TimeMapper timeMapper;
	@Test
	public void testGetTime() {
		log.info("날짜:"+timeMapper.getTime());		
	}
	@Test
	public void testGetTime2() {
		log.info("나아아아아아알짜2:"+timeMapper.getTime2());
	}
}
