package com.example.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //
public class RequestHomeworkController {
    @PostMapping(value = "register")
    public String requestSignUp(@RequestParam(name="id") String id, //
                              @RequestParam(name="password") String password,
                              @RequestParam(name="name") String name,
                              @RequestParam(name="yas") String yas,
                              @RequestParam(name="email_1") String email_1,
                              @RequestParam(name="email_2") String email_2){
        log.info(String.format("아이디 : %s", id));
        log.info(String.format("비밀번호 : %s", password));
        log.info(String.format("이름 : %s", name));
        log.info(String.format("성별 : %s", yas));
        log.info(String.format("email : %s%s", email_1, email_2));

        return "<script>alert('등록됨')</script><p>맴맴맴</p>";
    }

}
