package org.zerock.exception;



import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice //컨트롤러 추가내용
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)	//exception 발생시 실행
	public String except(Exception e, Model model) {
		model.addAttribute("e", e);
		log.error("예외발생===================================================="+e.getMessage());
		for(StackTraceElement ste :e.getStackTrace()) {
			log.error(ste);
		}
		return "error_page";
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException e) {
		log.error(e.getMessage());
		return "not_page";
	}
}
