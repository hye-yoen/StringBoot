package com.example.demo.Domain.Common.Dto;

import com.example.demo.Domain.Common.Emtity.user;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Controller ↔ Service ↔ Repository 사이에서 데이터 전달
//이거 view도 전달되는 거 같은데?
@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDto {

    @NotBlank(message = "유저이름을 입력하세요")
    private String username;
    @NotBlank(message="패스워드 입력")
    private String password;

    //Dto -> Entity 변환
    public user toEntity(){
        return user.builder()
                .username(this.username)
                .password(this.password)
                .createAt(LocalDateTime.now())
                .build();
    }

}
