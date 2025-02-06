package com.example.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ForwardRedirectController {
    @GetMapping("forward")
    public String forward(@RequestParam(name = "data") String data) {
        log.info("forward data={}", data); // 로그는 이렇게 쓰는것
        return "forward:/nextUrl";
    }

    @GetMapping("redirect")
    public String redirect(@RequestParam(name="data") String data) {
        log.info("redirect data={}", data);
        return "redirect:/nextUrl";
    }

    @GetMapping("nextUrl")
    public String nextUrl(@RequestParam(name="data", defaultValue =  "default") String data) {
        log.info("nextUrl data={}", data);
        return "index"; // /는 안되영
    }
}
