package edu.kwak.dao;

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
public class MstDAOTests {
	@Autowired
	MstDAO dao;
	
	@Test
	public void testInputProduct() {
		MstVO vo = new MstVO();
		vo.setCode("A06");
		vo.setPname("마우스패드");
		vo.setCost(1500);
		vo.setPnum(600);
		vo.setJnum(200);
		vo.setSale(4000);
		vo.setGcode("A");
		log.info("입력된 행 수 : "+dao.inputProduct(vo));
	}
	
	@Test
	public void testSearchProduct() {
		log.info("검색 결과 : " + dao.searchProduct("B01"));
	}
	
	@Test
	public void testModifyProduct() {
		MstVO vo = new MstVO();
		vo.setCode("A05");
		vo.setPname("무선마우스");
		vo.setCost(6500);
		vo.setPnum(1000);
		vo.setJnum(500);
		vo.setSale(12000);
		vo.setGcode("A");
		vo.setOgcode("A05");
		log.info("이렇게 쓸수있냐" + dao.modifyProduct(vo));
	}
	
	@Test
	public void testDeleteProduct() {
		log.info("삭제된 행 수 : "+dao.deleteProduct("A06"));
	}
	
	@Test
	public void testGroupName() {
		dao.groupName().forEach(x -> log.info(x));
	}
	
	@Test
	public void testPriorityProduct() {
		dao.priorityProduct().forEach(x -> log.info(x));
	}
	
	@Test
	public void testBenefitRank() {
		dao.benefitRank().forEach(x -> log.info(x));
	}
	
	@Test
	public void testJnumGroup() {
		dao.jnumGroup().forEach(x -> log.info(x));
	}
	
	@Test
	public void testList() {
		dao.list().forEach(x -> log.info(x));
	}
}
