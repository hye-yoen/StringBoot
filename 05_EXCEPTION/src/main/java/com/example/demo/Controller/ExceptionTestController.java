package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {
    //지역예외처리
//    @ExceptionHandler(FileNotFoundException.class) //exceptin 처리기 생성
//    public String exception_handler1(Exception e, Model model){
//        log.info("error : " + e);
//        model.addAttribute("ex",e);
//        return "except/error";
//    }

    @GetMapping("/ex1")
    public void ex1() throws FileNotFoundException{
        log.info("GET /except/ex1");
        throw new FileNotFoundException("파일을 찾을 수 없습니다.");
    }


    //특정예외처리 (ps.이거 맞아???)
//    @ExceptionHandler(ArithmeticException.class)
//    public String exception_handler2(Exception e)  {
//        log.info("error :  ",e);
//        return "except/error";
//    }
    @GetMapping("/ex2/{num}/{div}")
    public String ex2(
            @PathVariable int num,
            @PathVariable int div,
            Model Model
    ) throws ArithmeticException{
        log.info("GET /except/ex2...");
        Model.addAttribute("result",(num/div));
        return "except/ex2";
    }

    //모든 예외 처리
//    @ExceptionHandler(Exception.class) //exceptin 처리기 생성
//    public String exception_handler1(Exception e, Model model){
//        log.info("Exception error : " + e);
//        model.addAttribute("ex",e);
//        return "except/error";
//    }
    @GetMapping("/ex3")
    public void ex3() throws Exception{
        log.info("GET /except/ex3");
    }
}
