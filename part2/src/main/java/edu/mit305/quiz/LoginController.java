package edu.mit305.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mit305.cotroller2.Pro;

@Controller
public class LoginController {
	@RequestMapping("login")
	public void login() {}

	@RequestMapping("login.login")
	public String loginTry(String id, String pw) {
		if(id == null && pw == null) {
			return "login.login";
		}else {
			if(id.equals("admin") && pw.equals("admin")) {
				return "result/success";
			}else {
				return "result/fail";
			}
		}
	}
	@RequestMapping("rest")
	public @ResponseBody Pro doJSON() {
		Pro p = new Pro();
		p.setName("된장찌개");
		p.setPrice(7000);
		return p;
	}
}