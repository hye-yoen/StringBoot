package com.example.demo.DiTests;


import com.example.demo.Component.PersonComponent;
import com.example.demo.Dto.PersonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DiTests {

    @Autowired //만들어진 빈을 외부에서 연결(해주삼)
    private PersonComponent personComponent; //빈의 이름 지정 x -> 소문자로 지정해야 접근가능

    @Test
    public void t1(){
        System.out.println(personComponent);
    }

    @Autowired
    private PersonDto personDto; //이하동문

    @Test
    public void t2(){
        System.out.println(personDto);
    }
    @Autowired //만들어진 빈을 외부에서 연결(해주삼)
    private PersonDto person03; //빈이름 지정x 함수이름 o -> 함수이름
    @Test
    public void t3(){
        System.out.println(person03);
    }

    @Autowired
    private PersonDto personBean; //빈이름 지정 o
    @Test
    public void t4(){
        System.out.println(personBean);
    }

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void t5(){
        System.out.println(applicationContext.getBean("personBean"));
        System.out.println(applicationContext.getBean("person03"));
    }


}