package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeControllar {

    private static final Logger log = LoggerFactory.getLogger(HomeControllar.class);

    @GetMapping("/")
    public String Home(){
//        System.out.println("GET /");
        log.info("GET /...."); //info(로그레벨) : 일반적인 정보 수준
        return "index";
    }


}
