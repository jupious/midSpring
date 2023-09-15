package edu.kwak.mapper;

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
public class TodoMapperTests {
	@Autowired
	private TodoMapper tm;
	@Test
	public void testGetList() {
		log.info("====================getList테스트=========================");
		tm.getList().forEach(x -> log.info(x));
	}
	@Test
	public void testTodayList() {
		log.info("====================todayList테스트=========================");
		tm.todayList().forEach(x->log.info(x));
	}
	@Test
	public void testCount() {
		log.info("====================count테스트=========================");
		log.info("전체 일정 수: " + tm.count());
	}
	@Test
	public void testInsert() throws ParseException {
		log.info("====================count테스트=========================");
		TodoVO vo = new TodoVO();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		vo.setTitle("insert테스트~~~~~~~~~");
		vo.setDuedate(df.parse("2023-09-28"));
		
		log.info("삽입된 글 수 :"+tm.insert(vo));
	}
}
