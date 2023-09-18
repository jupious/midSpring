package edu.kwak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kwak.domain.TodoVO;
import edu.kwak.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*")
@AllArgsConstructor
@Log4j
public class TodoController {
	
	private TodoService ts;
	
	@GetMapping("list")
	public void list(Model model) {
		log.info("listURL");
		model.addAttribute("list", ts.getList());
	}
	
	@PostMapping("today")
	public void today(Model model) {
		log.info("todayURL");
		model.addAttribute("today", ts.todayTodo());
	}
	
	@PostMapping("count")
	public void count(Model model) {
		log.info("countURL");
		model.addAttribute("count",ts.count());
	}
	
	@GetMapping("input")
	public void input(TodoVO vo, Model model) {
		log.info("inputURL");
		model.addAttribute("inputRes", ts.inputTodo(vo));
	}
}
