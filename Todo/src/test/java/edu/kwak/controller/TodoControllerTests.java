package edu.kwak.controller;

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

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration		//컨트롤러 테스트용
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})	//컨트롤러 테스트용
@Log4j
public class TodoControllerTests {
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
				mockMvc.perform(MockMvcRequestBuilders.get("/todo/list")).andReturn().getModelAndView().getModelMap()
				);
	}
	@Test
	public void testToday() throws Exception {
		log.info("url리스트 요청결과 모델데이터" +		
				mockMvc.perform(MockMvcRequestBuilders.post("/todo/today")).andReturn().getModelAndView().getModelMap()
				);
	}
}
