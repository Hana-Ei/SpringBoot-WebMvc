package com.example.web.controller;

import com.example.web.exception.MemberNotFoundException;
import com.example.web.model.ErrorResult;
import com.example.web.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController  // return으로 html파일 주소가 아닌 html 문장으로써 취급함
public class ExceptionRestController {

    @GetMapping("error-test")
    public String test(){
        return "ok";
    }

    @GetMapping("member")
    public Member member(){
        Member member = new Member();
        member.setId("hong");
        member.setName("홍길동");
        return member;
    }
    @GetMapping("member/{id}")
    public Member getMember(@PathVariable("id") String id) throws Exception {
        log.info("id : {}", id);
        Member member = new Member();
        member.setId(id);
        member.setName("홍길동");

        if(id.equals("error")){
            throw new RuntimeException("잘못된 사용자");
        }
        if(id.equals("bad-request")){
            throw new IllegalArgumentException("잘못된 요청");
        }
        if(id.equals("member-ex")){
            throw new MemberNotFoundException("사용자를 찾을 수 없습니다.");
        }
        if(id.equals("exception")){
            throw new Exception("기타 예외");
        }
        return member;
    }

}
