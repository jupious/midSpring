package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class Log4Controller {
	
	@Before("execution(* org.zerock.controller.Board*.*(..))")
	public void boardControllerLog() {
		log.info("페이지 정보를 받아옴......");
	}
	
	@Before("execution(* org.zerock.controller.Comment*.*(..))")
	public void commentControllerLog() {
		log.info("댓글 데이터만 받아옴........");
	}
	@Before("execution(* org.zerock.controller.MyAPI*.*(..))")
	public void myAPIControllerLog() {
		log.info("MyAPI 컨트롤러 요청됨........");
	}
}
