package edu.kwak.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.kwak.domain.TodoVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoServiceImplTests {
	@Autowired
	private TodoService ts;
	
	@Test
	public void testGetList() {
		log.info("====================getList테스트=========================");
		ts.getList().forEach(x -> log.info(x));
	}

	@Test
	public void testTodayTodo() {
		log.info("====================todayTodo테스트=========================");
		ts.todayTodo().forEach(x -> log.info(x));
	}

	@Test
	public void testCount() {
		log.info("====================Count테스트=========================");
		log.info("전체 글 수:" + ts.count());
	}

	@Test
	public void testInputTodo() throws ParseException {
		log.info("====================inputTodo테스트=========================");
		TodoVO vo = new TodoVO();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		vo.setTitle("inputTodo테스트~~~~~~~~~");
		vo.setDuedate(df.parse("2023-09-18"));
		log.info("삽입 : " + ts.inputTodo(vo));
		
	}
}
