package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemoRepositoryTest {
    @Autowired
    private MemoRepository memoRepository;

    @Test //insert
    public void t1(){
        Memo memo = new Memo(null,"내용","test11@test.com", LocalDateTime.now());
        memoRepository.save(memo);
        System.out.println("ID : " + memo.getId());
    }

    @Test //내용 수정
    public void t2(){
        Memo memo = new Memo(1L,"수정된내용","test11@test.com", LocalDateTime.now());
        memoRepository.save(memo); //내용은 insert랑 같이 save씀 단 id가 있는거 넣으삼
    }

    @Test //delete
    public void t3(){
        memoRepository.deleteById(2L);
    }

    //단건 조회
    @Test
    public void t4(){
        Optional<Memo> memoOptional =  memoRepository.findById(3L);
        if(memoOptional.isPresent()){
            Memo memo= memoOptional.get();
            System.out.println();
            System.out.println(memo);
        }

    }

    //전체 조회
    @Test
    public void t5(){
        List<Memo> list = memoRepository.findAll();
        list.forEach(System.out::println);

    }


}