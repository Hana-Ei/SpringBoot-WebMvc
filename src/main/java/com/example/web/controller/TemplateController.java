package com.example.web.controller;

import com.example.web.model.Member;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j; //롬복꺼네 이거
import org.springframework.ui.Model; //이고쓰기
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class TemplateController {
    @GetMapping(value="text-basic") //주소로 이게 들어오면
    public String callTextBasic(Model model) {
        log.info("text-basic 호출됨");

        String message = "Hello Thymeleaf!";
//        model.addAttribute("message"); // name과 value가 같은 경우("message"가 데이터기도, 이름이기도 함) 사용
        model.addAttribute("data", message); //첫번째 : html에서 쓸 변수명, 두번째 : 데이터. 형식은 뭐든 가능하다.(class 또한)
        //model에 data란 이름으로 객체가 생성, message를 담아둠.
        return "thymeleaf/text-basic"; // 이 경로에 있는 html을 return해주는거임
    }
    @GetMapping(path = "text-unescaped")
    public String textUnEscaped(Model model) {
        model.addAttribute("data", "Hello <b>Thymeleaf</b>");
        return "thymeleaf/text-unescaped";
    }

    @GetMapping(path = "variable")
    public String variable(Model model) {
        Member member1 = new Member();
        member1.setId("user1");
        member1.setName("유저1");
        Member member2 = new Member();
        member2.setId("user2");
        member2.setName("유저2");

        model.addAttribute("user1", member1); // Class Object도 보낼 수 있엉
        model.addAttribute("user2", member2);

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);
        model.addAttribute("users", list); //클래스 오브젝트의 리스트도 들어감

        Map<String, Member> userMap = new HashMap<>();
        userMap.put("member1", member1);
        userMap.put("member2", member2);
        model.addAttribute("userMap", userMap); //클래스 오브젝트의 Map도 들어감

        return "thymeleaf/variable";
    }

    @GetMapping("date")
    public String basicObject(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "thymeleaf/date";
    }

    @GetMapping("link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "thymeleaf/link";
    }

    @GetMapping("literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring");
        return "thymeleaf/literal";
    }

    @GetMapping("operation")
    public String operation(Model model) {
        return "thymeleaf/operation";
    }

    @GetMapping("each")
    public String each(Model model) {
        List<Member> list = new ArrayList<>();

        Member member1 = new Member();
        member1.setId("user1");
        member1.setName("유저1");
        member1.setEmail("aaa@naver.com");
        Member member2 = new Member();
        member2.setId("user2");
        member2.setName("유저2");
        member2.setEmail("bbb@naver.com");
        Member member3 = new Member();
        member3.setId("user3");
        member3.setName("유저3");
        member3.setEmail("ccc@naver.com");

        list.add(member1);
        list.add(member2);
        list.add(member3);
        model.addAttribute("list", list);

        return "thymeleaf/each";
    }

    @GetMapping("condition")
    public String condition(Model model) {
        Member member1 = new Member();
        member1.setId("user1");
        member1.setName("유저1");
        member1.setEmail("user1");
        member1.setDomain("gmail");
        Member member2 = new Member();
        member2.setId("user2");
        member2.setName("유저2");
        member2.setEmail("user2");
        member2.setDomain("naver");
        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);

        model.addAttribute("member", member1);
        model.addAttribute("list", list);

        return "thymeleaf/condition";
    }
    @GetMapping("comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring");

        return "thymeleaf/comments";
    }

    @GetMapping("block")
    public String block(Model model) {
        Member member1 = new Member();
        member1.setId("user1");
        member1.setName("유저1");
        member1.setEmail("user1");
        member1.setDomain("gmail");
        Member member2 = new Member();
        member2.setId("user2");
        member2.setName("유저2");
        member2.setEmail("user2");
        member2.setDomain("naver");

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);

        model.addAttribute("list", list);
        return "thymeleaf/block";
    }

    @GetMapping("javascript")
    public String javascript(Model model) {
        Member member1 = new Member();
        member1.setId("user1");
        member1.setName("유저1");
        member1.setEmail("user1");
        member1.setDomain("gmail");
        Member member2 = new Member();
        member2.setId("user2");
        member2.setName("유저2");
        member2.setEmail("user2");
        member2.setDomain("naver");

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);

        model.addAttribute("member", member1);
        model.addAttribute("list", list);

        return "thymeleaf/javascript";
    }
}
