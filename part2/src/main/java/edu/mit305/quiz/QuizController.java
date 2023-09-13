package edu.mit305.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {

	@RequestMapping("quiz1")
	public void quiz1() {
		
	}
	@RequestMapping("result1")
	public String result1(Integer num1, Integer num2, Model model) {
		if(num1 != null && num2 != null) {
			int sum = 0, temp,t1 = num1,t2 = num2;
			if(t1 > t2) {
				temp = t1;
				t1 = t2;
				t2 = temp;
			}
			for(int i = t1; i <= t2; i++) {
				sum += i;
			}
			model.addAttribute("sum",sum);
		}else {
			model.addAttribute("error","숫자를 넣으셨어야지 ㅋㅋ");
		}
		
		return "quiz/result1";
	}
}
