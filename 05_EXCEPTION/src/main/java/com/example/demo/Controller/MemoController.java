package com.example.demo.Controller;

import com.example.demo.Domain.Common.Dto.MemoDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

//    @ExceptionHandler(Exception.class)
//    public String exception_handler(Exception e){
//        log.error("MemoController's Exception..." + e);
//        return "memo/error";
//    }


    @InitBinder //WebDataBinder  초기화
    public void dataBinder(WebDataBinder webDataBinder){ //WebDataBinder 요청 매개변수(form 또는 query 데이터)를 모델 객체에 바인딩
        log.info("MemoController's dataBinder..." + webDataBinder);
        webDataBinder.registerCustomEditor(LocalDate.class, "data_test",new DataTestEditor() );
        //Local class의 필드(data_Test)를 새로운  DataTestEditor로 반환
    }

    private static class DataTestEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            log.info("DataTestEditor's setAsText text : " + text);
            LocalDate date = null;
            if(text.isEmpty()){
                date = LocalDate.now();
                 //text가 비어 있다면 현재 날짜 고정

            }else{
                //format 확인(yyy#MM#dd)
                text = text.replaceAll("#","-"); //# -> -
                date = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")); //text를 datetime (패턴) 형태로 변환
            }
            setValue(date);
        }
    }

    @GetMapping("/add")
    public void add_memo_get() {
        log.info("GET /memo/add...");
    }
    @PostMapping("/add")
    public void add_memo_post(@Valid MemoDto dto, BindingResult bindingResult, Model model){  //BindingResult => 검증 오류 처리 및 보관 객체
        log.info("POST /memo/add..." +dto);
        //파라미터
        //입력값 검증(데이터)
        log.info("유효성 오류 발생여부 : "+bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            for(FieldError error : bindingResult.getFieldErrors()){
                log.info("Error Field: "+error.getField()+ "Error Message : "+error.getDefaultMessage());
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }
        }
        throw new NullPointerException("예외발생");
        //서비스 요청
        //뷰로 이동 -> Domaon.Common.Service
    }
}
