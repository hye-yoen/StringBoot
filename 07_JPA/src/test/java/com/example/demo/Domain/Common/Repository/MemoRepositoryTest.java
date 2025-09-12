package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @BeforeEach //테스트 하기 전 실행
    public void post1000(){
        if(memoRepository.count() ==0){
            for(int i =0 ; i<1000 ; i++){
                memoRepository.save(new Memo(null,"TEXT-"+i,"WRITER-"+i,LocalDateTime.now()));
            }
        }
    }

    @Test
    public void t6(){
        System.out.println(memoRepository.count());
        // Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());/ 0페이지, 사이즈 10, id 내림차순
        Pageable pageable = PageRequest.of(0,10);
                //페이지 넘버, 페이지당 들어갈 데이터 수
        Page<Memo> page = memoRepository.findAll(pageable);

        //페이지 메타 확인
        System.out.println("현재 페이지 번호"+page.getNumber());
        System.out.println("한 페이지에 표시할 건수"+page.getSize());
        System.out.println("총게시물 갯수"+page.getTotalElements());
        System.out.println("총페이지 갯수"+page.getTotalPages());
        System.out.println("첫번째 페이지인지 여부"+page.isFirst());
        System.out.println("다음 페이지가 있는지 여부"+page.hasNext());
        System.out.println("이전 페이지가 있는지 여부"+page.hasPrevious());

        //실제 데이터
        List<Memo> list = page.getContent();
        list.forEach(System.out::println);

        System.out.println("======");

        //다음 페이지 요청
        Page<Memo> nextPage = memoRepository.findAll(page.nextPageable());
    }


}