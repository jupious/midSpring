package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("접근 거부됨 " + auth);
		model.addAttribute("msg", auth);
		
	}
	
	@GetMapping("/customLogin")
	public void customLogin(String error, String logout) {
		if(error!=null)
			log.info("로그인 요청시 에러정보: " + error);
		if(logout!=null)
			log.info("로그아웃시 정보: " + logout);
		
		
	}
	
	@GetMapping("/customLogout")
	public void logoutGet() {
		log.info("로그아웃 페이지 요청됨");
	}
}
