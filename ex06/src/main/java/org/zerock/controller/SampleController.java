package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping("/all")
	public void doAll() {
		log.info("누구나 접근 가능");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("로그인한 사용자만 접근가능");
	}
	
	@GetMapping("/admin")
	public void doAdmint() {
		log.info("관리자만 접근가능");
	}
	
	
}
