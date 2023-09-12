package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component	//스프링에서 관리되는 객체 (검색할 패키지도 표기해야함)
@Data		//롬복에서 데이터관련 메소드자동생성
public class Chef {
	private String name = "김쉪";
	private String food = "돈가스";
	
	
}
