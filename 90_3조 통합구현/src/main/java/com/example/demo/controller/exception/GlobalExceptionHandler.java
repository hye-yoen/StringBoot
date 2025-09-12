package com.example.demo.controller.exception;
// 모든 예외(Exception.class)를 잡아 공통 에러 페이지로 이동
// except/error.jsp로 리다이렉트

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice   // 모든 컨트롤러의 예외를 처리하는 전역 핸들러
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)  // Exception 및 그 하위 예외 처리
	public String AllExceptionExceptionHandler(Exception e, Model model) {
        // 예외 로그 출력
		log.info("GlobalExceptionHandler's error : " + e);
        //예외발생시 webapp/WEB-INF/views/except/error.jsp로 이동합니다
		return "except/error";
	}
}







