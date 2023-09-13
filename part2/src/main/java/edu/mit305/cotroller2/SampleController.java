package edu.mit305.cotroller2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping("ex05")
	public void ex05() {
		//->ex05.jsp
		//기본은 디스패쳐
	}
	
	@RequestMapping("test2")
	public String bbb() {
		return "ex05";
	}
	@RequestMapping("test3")
	public String ccc() {
		return "redirect:test2";	//리다이렉트 요청
	}
	@RequestMapping("test4")
	public String test4(Model model) {
		model.addAttribute("name","이름없음");
		int how = 100;
		model.addAttribute(how);
		Pro pd = new Pro();
		pd.setName("타피오카 펄");
		pd.setPrice(500);
		model.addAttribute("product",pd);
		model.addAttribute(pd);	//이름없이 보내면 이름은 해당 클래스 이름으로 (첫글자는 소문자)
		return "productDetail";
	}
	@RequestMapping("input")
	public String input() {
		return "test/input";
	}
	
	@RequestMapping("ex01")
	public void ex01(String name, int age, Pro pro) {
		System.out.println("name 수집: "+name);
		System.out.println("age 수집: "+age);
		System.out.println(pro);

	}
}
