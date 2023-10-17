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
	@Test
	public void str1() {
		String a = "421b99d4-eea5-4d23-941e-387f830f153b_202___3.png";
		String[] b = null;
		if(a.startsWith("s_")) {
			log.info("썸네일임");
			b = a.split("_",3);
		}else {
			log.info("썸네일 아님");
			b = a.split("_",2);
		}
		log.info("파일이름= "+ b[1]);
	}
}
