package com.example.demo.controller;
// 메모 작성 페이지 요청과 저장 처리 담당 컨트롤러
// GET /memo/add -> 입력 폼 페이지 이동
// POST /memo/add -> 유효성 검사 후 DB 저장

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.service.MemoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/memo")    // 기본 경로 /memo
public class MemoController {

    @Autowired
    private MemoService memoService;    // MemoService 주입

    // 메모 작성 폼 페이지로 이동 (GET)
    @GetMapping("/add") //요청에 맞는 페이지를 출력
    public void add_get() {
        log.info("GET /memo/add...");
        //"/add"를 요청하면 /WEB-INF/views/memo/add.jsp가 호출
    }

    // 메모 작성 처리 (POST)
    @PostMapping("/add")
    public String add_post(@Valid MemoDto dto,                      // 폼 입력값 바인딩 및 유효성 검증
                           BindingResult bindingResult,             // 유효성 결과 저장
                           Model model,                             // 뷰로 데이터 전달
                           RedirectAttributes redirectAttributes    // 리다이렉트 시 데이터 전달
    ) throws Exception {
        log.info("POST /memo/add...");

        //01 파라미터 받기(MemoDto)

        //02 유효성 검증(BindingResult)
//        log.info("유효성 오류 발생여부 : " + BindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                // 에러 메시지를 뷰에 전달
                log.info("Error Field : " + error.getField() + " Error Message : " + error.getDefaultMessage());
                model.addAttribute(error.getField(), error.getDefaultMessage());
            }
            //throw new Exception("유효성 검증 오류!");
            return "memo/add"; // 다시 작성 폼으로 이동
        }
        //- 유효성 검증 오류 발생시 -> memo/add 이동(오류필드 메시지 전달)


        //03 서비스 실행(memoService(dto) 전달 후 memoId값 반환)
        Long insertedId = memoService.addMemoTx(dto);
        if (insertedId != null)
            redirectAttributes.addFlashAttribute("message", "메모저장 성공 ID : " + insertedId);

        //04 뷰로 이동 redirect:/ , 리다이렉트 메시지 전달
        //redirectAttributes.addFlashAttribute("result","메모저장 성공 ID : " + memoId);
        return insertedId != null ? "redirect:/" : "memo/add";
    }

}


// 실행 흐름
// 1. 사용자가 GET /memo/add요청
//  - add_get() 실행
//  - memo/add.jsp 출력

// 2. 사용자가 입력 후 POST /memo/add요청
//  - 스프링이 요청한 파라미터를 MemoDto에 바인딩
//  - @Valid 검증 수행

// 3. 검증 실패
//  - bindingResult.hasErrors() -> true
//  - 에러 메시지 로그 출력 및 모델 담기
//  - memo/add.jsp 다시 표시

// 4. 검증 성공
//  - memoService.addMemoTx(dto) 실행 -> DB저장
//  - 저장된 엔티티의 id 반환
//  - redirect:/ 실행 -> 메인 페이지(index.jsp)로 이동