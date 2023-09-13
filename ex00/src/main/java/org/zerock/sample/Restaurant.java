package org.zerock.sample;


import org.springframework.stereotype.Component;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
//@ToString 					//toString 자동생성과 같음(필드값을 출력할수있는 toString메소드를 오버라이드)
//@AllArgsConstructor		//필드를 다 생성할수있는 생성자를 만들어라
@RequiredArgsConstructor 	//필요한 필드만 세팅할 수 있는 생성자를 만들어라(@NonNull or final)
public class Restaurant {
	
	//@Setter(onMethod_ = @Autowired)	//어노테이션으로 setter자동생성		- 셋터주입
	//Chef chef;						//autowired - 스프링에서 해당하는 객체를 자동으로 주입
	
	//@Autowired						//필드주입
	@NonNull	//필요한 생성자 셋팅 (RequiredArgsConstructor)
	Chef chef;
	
	
										//생성자 주입 - 스프링 4.3이상부터는 autowired 생략가능
//	public Restaurant(Chef chef) {
//		this.chef = chef;
//	}
}
