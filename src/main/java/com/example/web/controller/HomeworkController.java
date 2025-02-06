package com.example.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeworkController {
    @GetMapping("signup") // 메서드명과 주소명은 같을 것.
    public String signUp(){
        log.info("signup() 메서드 호출");
        return "signup"; //templates 내의 html 이름과 같아야함
    }
}
