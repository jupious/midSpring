package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.AfterTransaction;

import lombok.extern.log4j.Log4j;

@Aspect //Aspect를 구현할 클래스 명시
@Log4j
@Component
public class LogAdvice {
	//*:모든값에 대해 (..):0개 이상
	//모든 접근제한자를 가진 SampleService의 모든 메서드중 파라미터가 0개이상 있는 메서드가 실행될때
	@Before("execution(* org.zerock.service.SampleService*.*(..))") 
	public void logBefore() {
		log.info("=====================서비스 시작전 찍힐 로그======================");
	}
														//메소드(변수타입,변수타입) args(변수명)
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {

	    log.info("str1: " + str1);
	    log.info("str2: " + str2);
	}
	
	//예외가 발생되었을때만 실행
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
	   
	    log.info("=====================예외발생시 찍힐 로그======================");
	    log.info("exception: "+ exception);
	  
	}
	 
	//메소드의 실행 자체를 제어(@Around 사용시엔 반환형을 Object(또는 걸린 메소드의 반환형)로 지정해줘야한다 void타입 불가)
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	  public Object logTime( ProceedingJoinPoint pjp) {
	    
	    long start = System.currentTimeMillis(); //현재시간의 ms값 가져오기
	    
	    log.info("Target: " + pjp.getTarget()); //pointcut으로 지정된 타겟 출력
	    log.info("Param: " + Arrays.toString(pjp.getArgs()));	//지정된 파라미터 출력
	    
	    
	    //invoke method 
	    Object result = null;
	    
	    try {
	      result =  pjp.proceed();	//해당 메소드 실행(반환형은 Object)
	    } catch (Throwable e) {
	     
	      e.printStackTrace();
	    }
	    
	    long end = System.currentTimeMillis();	
	  
	    log.info("TIME: "  + (end - start));	//총 수행 ms구하기
	    
	    return result;
	  }
	
	@Before("execution(* org.zerock.mapper.SampleMapper*.*(..))")
	public void testWhy() {
	   
	    log.info("=====================태스트용 로그======================");
	    log.info("exception: ");
	  
	}
	
}
