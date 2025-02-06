package com.example.web.controller;

import com.example.web.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
