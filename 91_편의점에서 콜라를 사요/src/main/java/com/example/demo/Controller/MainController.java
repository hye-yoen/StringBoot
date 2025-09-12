package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping(value = "/") //전체기준(WEB-INF/views == http://localhost:8090/)
    public String home(){
        log.info("GET /");
        return "main";
    }
}
