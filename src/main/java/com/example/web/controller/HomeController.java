package com.example.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//↓ Spring의 Bean으로 설정하는 구문 -> 컴포넌트 스캔을 통해 서버가 시작할 때 스프링이 객체로 생성. 정확히는 생성자를 호출
@Controller // 존재하지 않을 경우, Spring은 이 아이를 이용하지 않고 프로그램을 생성한다.
// Main문에 적어두면 쓰긴 할껄?
@Slf4j //lombok의 log.메서드
public class HomeController {

    // DI : 의존성 주입
    // IoC : 제어의 역전 - 객체의 생성권을 Spring이 가진다
    // AoP : 관점 지향 프로그래밍

    public HomeController() { //생성자임.
        System.out.println("HomeController");
    }

    @RequestMapping(path = "hello", method = RequestMethod.GET) // 링크 "Hello"에서 RequestMethod.GET을 받으면 이 메서드를 실행한다
    // Post의 경우, 주소에 데이터를 저장하지 않기에, Get형식의 호출(주소)을 처리할 수 없다.
//    @GetMapping(value = "hello")
    @ResponseBody // Response로 문자열을 받았을 시, 그 문자열이 적힌 html파일을 띄운다.
    public String home(){ //메서드임. Spring에서의 String은 보통 파일의 경로를 뜻한다.
//        System.out.println("home() 메서드 호출");
        //Trace -> Debug -> Info -> Warn -> Error. 로그가 가져다주는 정보의 단계
        //Trace, Debug : 매우 상세함. 근디 딱히 중요하지 않음
        //Info. 기본 정보
        //Warn, Error : 로보토미 2, 3단계 브금. 겁나 중요한 정보
        log.info("home() 메서드 호출"); //부가정보 잔뜩 주는 sysout

        return "Hello Spring"; // No static resource Hello Spring.
    }

    @RequestMapping(path = "spring", method = RequestMethod.GET)
    public String spring(){
        log.info("spring() 메서드 호출");
        return "spring";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){
        log.info("index() 메서드 호출");
        return "index"; //templates 내의 html 이름과 같아야함
    }
}
