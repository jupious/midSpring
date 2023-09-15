package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService bs;	//생성자 주입
	
	@GetMapping("list")
	public void list(Model model) {
		log.info("========================= list URL요청 =========================");
		model.addAttribute("list",bs.getList());
	}
	
	@PostMapping("register")
	public void register(BoardVO vo) {
		log.info("========================= register URL요청 =========================");
		bs.register(vo);
	}
	
	@GetMapping("get")
	public void get(Long bno, Model model) {
		log.info("========================= get URL요청 =========================");
		model.addAttribute(bs.get(bno));
	}
	
}
