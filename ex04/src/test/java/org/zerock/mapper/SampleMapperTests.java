package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleMapperTests {
	@Autowired
	private SampleMapper s1m;
	
	@Test
	@Transactional	//트랜잭션으로 묶어준다 에러가나면 그 밑은 무시하고 롤백하는듯?
	public void testInsert() {
		s1m.insertCol1("aaa");
		s1m.insertCol2("bbbasdfasdfasdj");
		log.info("여기옴?");
		s1m.insertCol1("bbb");
	}
}
