package edu.kwak.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.kwak.domain.MstVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MstServiceImplTests {
	@Autowired
	private MstService ms;
	
	@Test
	public void testInsert() {
		MstVO vo = new MstVO();
		vo.setCode("A06");
		vo.setPname("마우스패드");
		vo.setCost(1500);
		vo.setPnum(600);
		vo.setJnum(200);
		vo.setSale(4000);
		vo.setGcode("A");
		ms.insert(vo);
	}
	
	@Test
	public void testSearch() {
		ms.search("A05");
	}
	
	@Test
	public void testModify() {
		MstVO vo = new MstVO();
		vo.setCode("A05");
		vo.setPname("유선마우스");
		vo.setCost(6500);
		vo.setPnum(1000);
		vo.setJnum(500);
		vo.setSale(12000);
		vo.setGcode("A");
		vo.setOgcode("A05");
		ms.modify(vo);
	}
	
	@Test
	public void testDelete() {
		ms.delete("A06");
	}
	
	@Test
	public void testGroupList() {
		ms.groupList().forEach(x -> log.info(x));
	}
	
	@Test
	public void testPriority() {
		ms.priority().forEach(x -> log.info(x));
	}
	
	@Test
	public void testBenefit() {
		ms.benefit().forEach(x -> log.info(x));
	}
	
	@Test
	public void testJGroup() {
		ms.jGroup().forEach(x -> log.info(x));
	}
}
