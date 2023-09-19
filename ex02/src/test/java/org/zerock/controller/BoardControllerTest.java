package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration		//컨트롤러 테스트용
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})	//컨트롤러 테스트용
@Log4j
public class BoardControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;	//이 객체를 이용해서 컨트롤러를 테스트해야함
								//객체를 직접 생성해야함(인스턴스화)
	
	@Before	//junit으로 테스트할때 먼저 수행하는 메소드
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info("url리스트 요청결과 모델데이터" +		//get으로 요청해라            모델의 뷰를 가져와라/ 보낸 데이터확인
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap()
				);
	}
	@Test
	public void testRegister() throws Exception {
		log.info("url Regist 요청 테스트" +
		mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "registControllerTest")
				.param("content", "내용임")
				.param("writer", "작성자1"))
			.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGet() throws Exception {
		log.info("url Get 요청 테스트" + 
		mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "3"))
			.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRemove() throws Exception {
		log.info("url Remove 요청 테스트" +
		mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "43"))
			.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testModify() throws Exception {
		log.info("url Modify 요청 테스트" +
		mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "3")
				.param("title","modifyControllerTest")
				.param("content", "컨트롤러가 수정함 내가봄"))
			.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRegi() throws Exception {
		log.info("register Get : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/register")).andReturn().getModelAndView().getViewName());
		
	}
	
	@Test
	public void testRm() throws Exception {
		log.info("remove Get : "+mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")).andReturn().getModelAndView().getViewName());
		
	}
	@Test
	public void testPat() throws Exception {
		log.info("url리스트 요청결과 모델데이터" +		//get으로 요청해라            모델의 뷰를 가져와라/ 보낸 데이터확인
				mockMvc.perform(MockMvcRequestBuilders.get("/board/charts")).andReturn().getModelAndView().getModelMap()
				);
	}
}
