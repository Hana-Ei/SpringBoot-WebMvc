package com.example.web.controller;

import com.example.web.exception.MemberNotFoundException;
import com.example.web.model.Member;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@Slf4j
public class ExceptionController {
    @GetMapping("error-ex")
    public String errorEx(){
        throw new RuntimeException("강제 런타임 에러 발생");
    }
    @GetMapping("error-404")
    public String error404(HttpServletResponse response) throws IOException {
        response.sendError(404, "404오류 발생");
        return "/index";
    }
    @GetMapping("error-500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500, "500오류 발생");
    }
    @GetMapping("error-member")
    public String errorMember(@RequestParam(name="id") String id) throws IOException {
        log.info("id: {}", id);

        Member member = new Member();
        member.setId("hong");
        member.setName("홍길동");

        if(member.getId().equals(id)){
            log.info("member:{}", member);
        } else{
            throw new MemberNotFoundException(id + "에 해당하는 멤버가 없습니다.");
        }
        return "index";
    }
    @ExceptionHandler(MemberNotFoundException.class)
    public String MemberNotFoundHandle(){
        log.info("MemberNotFoundException 샐행");
        return "custom-error";
    }
    @ExceptionHandler(RuntimeException.class)
    public String RuntimeHandle(RuntimeException e, Model model){
        log.info("RuntimeException 실행");
        model.addAttribute("message", e);
        return "custom-error";
    }
}
