package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lend") //테이블 명 따로 지정 없으면 클래스명 == 테이블명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // n:1
    @JoinColumn (  //어떤 컬럼과 연결될지 사용 할때
        name ="username",  //표시할 외래키 컬럼명
        foreignKey =  @ForeignKey(
                name="FK_LEND_USER",
                foreignKeyDefinition = "FOREIGN KEY (username)  REFERENCES user(username) ON DELETE NO ACTION ON UPDATE CASCADE"
        )
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name="bookCode",
            foreignKey = @ForeignKey(name="FK_LEND_BOOK", //결론 : 백틱빼삼 그거때문에 애초에 안 들어가짐 ㄷ
                    foreignKeyDefinition = "FOREIGN KEY (BookCode) REFERENCES book(BookCode) ON DELETE NO ACTION ON UPDATE CASCADE"
            )
    )
    private Book book;
}
