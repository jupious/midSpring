package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.SampleVO;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration		//컨트롤러 테스트용
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})	//컨트롤러 테스트용
@Log4j
public class SampleControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;	//이 객체를 이용해서 컨트롤러를 테스트해야함
								//객체를 직접 생성해야함(인스턴스화)
	
	@Before	//junit으로 테스트할때 먼저 수행하는 메소드
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testTicket() throws Exception {
		//넣어주기 위한 json data
		SampleVO vo = new SampleVO(1212, "점심", "김씨");
		Gson gson = new Gson();
		String jsonData = gson.toJson(vo);
		log.info("변환된 데이터 "+jsonData);
			
		mockMvc.perform(MockMvcRequestBuilders.post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(jsonData))
			.andExpect(status().is(200));
			//andExpect(상태코드) - 원하는 상태코드가 맞으면 성공 아니면 실패
	}
	// CRUD	 = read,create,update,delete
	//method = get, post,  put,   delete
}
