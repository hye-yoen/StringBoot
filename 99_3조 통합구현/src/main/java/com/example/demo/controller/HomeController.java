package com.example.demo.controller;
// 애플리케이션의 루트 경로(/) 요청 처리
// "/" 요청 시 index.jsp반환
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링 MVC 컨트롤러
@Slf4j      // Lombok 로그 지원
public class HomeController {

    @GetMapping(value = "/")    // 루트("/") 요청 처리
    public String home(){

        log.info("GET /");      // 로그 출력
        return "index";         // -> /WEB-INF/views/index.jsp 렌더링
    }
}
