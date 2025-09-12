package com.example.demo.Controller.GlobalException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j //롬북지원 (feat. 로그)
public class GlobalExceptioHandler {
    @ExceptionHandler(Exception.class) //Exception 및 그 하위 객체 처리
    public String allExceptionHandler(Exception e){
        log.info("Global Exception Handler... " + e);
        return "except/error"; //jsp 파일 경로 반환
    }
}
