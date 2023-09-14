package org.zerock.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/**")
@Log4j
public class SampleController {

	@RequestMapping("")	//매핑이 안된 하위url을 모두 받음 ex)sample/, sample/asdafa
	public void all() {
		log.info("아무거나줘-----------------------------------------");
	}
	
	@RequestMapping(value = "basic",method = {RequestMethod.POST})	//sample/basic 메소드 매핑가능, 콤마로 여러개
	public void basic() {
		log.info("basiccccccccccccccccccccccccccccccccccccccccccc");
	}
	
	@GetMapping("basicOnlyGet")	//sample/basicOnlyGet.jsp
	public void basic2() {
		log.info("basicOnlyGettttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		
	}
	
	//sample/ex01?name=AAA&age=10
	@GetMapping("ex01")		//view/ex01.jsp	
	public String ex01(SampleDTO dto) {
		log.info("수집된 "+dto);
		//int a=5/0;
		return "ex01";
	}
	//sample/ex02?name=AAA&age=10
	@GetMapping("ex02")
	public void ex02(@RequestParam("name")String id,@RequestParam("age") Integer num) {
		log.info("name = "+id+" age = "+num);
	}
	//sample/ex02List?ids=111&ids=222&ids=333
	@GetMapping("ex02List")
	public void ex02List(@RequestParam("ids") ArrayList<String> ids) { //리스트는 어노테이션 필요 - setter가 이용되기때문
		log.info("List ids : " + ids);
	}
	
	//sample/ex02Array?ids=111&ids=222&ids=333
	@GetMapping("ex02Array")
	public void ex02List(String[] ids) { //배열은 어노테이션 없어도 받아진다
		log.info("Array ids : " + Arrays.toString(ids));
	}
	
	//sample/ex02Bean?list[0].name=aaa&list[0].age=111&list[1].name=bbb&list[1].age=222
	//url 인코딩 - /sample/ex02Bean?list%5B0%5D.name=aaa&list%5B0%5D.age=111&list%5B1%5D.name=bbb&list%5B1%5D.age=222
	@GetMapping("ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		log.info("list : " + list);
	}
	
	//input type="date" 일때는 java.sql.Date쓰면 해결됨
	//아닐때는 2가지방법으로 해결가능
	//1. @InitBinder 사용
	//2. @DateTimeFormat(pattern = "")사용
	//sample/dateTest
	@PostMapping("dateTest")	
	public String dateTestPost(@DateTimeFormat(pattern ="yyyy-MM-dd") Date today) {
		log.info(today);
		return "dateTest";
	}
	
	@GetMapping("dateTest")
	public String dateTestGet() {
		log.info("dateTestGet");
		return "dateTest";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df, false));
//	}
	//ex04?name=AAA&page=10
	@GetMapping("ex04")
	public void ex04(SampleDTO dto, @ModelAttribute("pp") Integer p) {
		log.info("dto : " + dto);
		log.info("page: " + p);
	}
	
	//ex04re?name=AAA&page=10
		@GetMapping("ex04re")
		public String ex04re(SampleDTO dto, Integer page, RedirectAttributes rttr) {
			rttr.addFlashAttribute("page",page);
			log.info("dto : " + dto);
			log.info("page: " + page);
			return "redirect:/sample/ex04reView";
		}
		
		@GetMapping("ex04reView")
		public void ex04reView() {}
		
		//sample/ex07
		//http상태 200정상, 404없음, 500내부에러, 400요청에러
		@GetMapping("ex07")
		public ResponseEntity<String> ex07() {
			log.info("ex077777777777777777777777777777777777777777777777777");
			//전송한 json data = {"name" : "홍길동"}
			String msg = "<script>alert('넌 못지나간다');location.href='/home'</script>";
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "text/html;charset=UTF-8");
			//header.add("Content-Type", "image/jpeg");
			
			return new ResponseEntity<String>(msg,header,HttpStatus.NOT_FOUND);	//<>(data,header,status)
		}

}














