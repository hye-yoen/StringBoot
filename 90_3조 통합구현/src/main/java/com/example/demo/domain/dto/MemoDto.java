package com.example.demo.domain.dto;
// DTO(data Transfer Object):클라이언트 <-> 서버, Controller <-> Service <-> Entity 간 데이터 전송 객체
// 뷰에서 입력한 데이터를 엔테테(Memo)로 변환하거나, 반대로 엔티티 데이터를 뷰로 전달

import com.example.demo.domain.entity.Memo;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data                   // Getter and Setter, toString 등 자동 생성
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 전체 필드 생성자
public class MemoDto {

	@NotBlank(message="메모를 입력하세요")      // text가 비어있으면 검증 오류
	private String text;
	@NotBlank(message="작성자를 입력하세요")      // writer가 비어있으면 검증 오류
	@Email(message="example@example.com에 맞게 입력해주세요")    // 이메일 형식 검증
	private String writer;

    // DTO -> Entity 변환
    public Memo toEntity() {
        return Memo.builder()
                .text(this.text)
                .writer(this.writer)
                .createAt(LocalDateTime.now())   //현시간 저장
                .build();
    }
    // Entity -> DTO 변환
    public static MemoDto fromEntity(Memo memo) {
        if (memo == null) return null;
        return new MemoDto(
                memo.getText(),
                null    //writer는 현재 null 처리 (추후 필요 시 수정 가능)
        );
    }

}

// 실행 흐름
// 1. 사용자 입력 -> DTO
//  - add.jsp에서 입력한 text, writer 값이 MemoDto에 담김
// 2. 컨트롤러 -> 서비스 전달
//  - MemoController.add_post()에서 MemoDto를 memoService.addMemoTx()로 전달
// 3. DTO -> Entity 변환
//  - 서비스 계층에서 dto.toEntity()호출 -> JPA가 DB에 저장할 수 있는 Memo엔티티  객체 생성
// 4. Entity -> DTO 변환(필요 시)
//  - DB에서 조회한 Memo를 다시 MemoDto로 변환하여 뷰로 전달
