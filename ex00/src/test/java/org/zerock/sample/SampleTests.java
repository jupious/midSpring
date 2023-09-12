package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	//junit으로 테스트할때 스프링프레임워크를 이요해서 해라
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	//스프링 프레임워크 설정파일주소
@Log4j
public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant); //junit에서 제공하는 메소드로 해당 객체가 null이 아니면 성공
		log.info(restaurant);
	}
}
