package edu.mit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
	
	@GetMapping("input")
	public void input() {}
	
	@GetMapping("result")
	public void result(int num1, int num2, Model model) {
		int sum = 0;
		for(int i = num1; i <= num2 ;i++) {
			sum+=i;
		}
		model.addAttribute("sum", sum);
	}
}
