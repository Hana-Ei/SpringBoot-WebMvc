package com.example.web.controller;

import com.example.web.model.Member; // java부터 내려옴
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //
public class RequestParamController {

    //Servlet Request로 param을 받는 방법
    @GetMapping(value = "requestParamV1") //param을 받는다. HttpServlet은 parameter가 없으면 null로 채움
    public String requestParamV1(HttpServletRequest request){ //request로 받은 모든 정보 ? 뒤에 오는 모든 애를 가지는 Object로 생각하면 편함
        String param = request.getParameter("param"); // html에게 받는 파리머터명은 param, ? 뒤에 파라미터를 지정해준다(Get의 경우)
        log.info("ParamV1: {}", param); // param의 형식을 따로 지정해 줄 순 없다. @requeestParam은 가능하다.
        return "<h1>ok<h1>"; // html문으로써 작동함.
    }

    //param이 있어야 하는 request는,request 없이 호출할 경우 'bad request' 오류가 뜬다
    @GetMapping(value = "requestParamV2")
    public String requestParamV2(@RequestParam(name="param") String param, // param이라는 파라미터(name에 걔)를 param이라는 변수로 받는다.
         @RequestParam(name="id") String id){  // parameter가 두개인 경우, 이런식으로 나눈다. 주소창에서는 &로 나눈다
        log.info("ParamV2: {}", param); // parameter는 항상 문자열일 이유가 없다. int써도 됨. 문자열은 못받겟지만
        log.info("id: {}", id); // int 선언해놓고 문자열 주면 bad request
        return "<h1>ok</h1><br><p>this ok is come from requestParamV2</p>";
    }

    @GetMapping(value = "requestParamV3")
    //PostMapping의 경우 Post 요청을 처리할 수 있음.
    public String requestParamV3(@RequestParam(name="param", required = false) String param, // 값 없으면, 그 값을 null로 취급하여 실행
         @RequestParam(name="id", defaultValue="") String id){ // 값 없으면, 기본값을 ""로 지정
        log.info("ParamV3: {}", param);
        log.info("id: {}", id); 
        return "<h1>ok</h1><br><p>this ok is come from requestParamV3</p>";
    }

    @PostMapping(value = "requestParamV5")
    //PostMapping의 경우 Post 요청을 처리할 수 있음.
    public String requestParamV5(@ModelAttribute Member member){
        log.info("ParamV5: {}", member);
        return "<h1>ok</h1><br><p>this ok is come from requestParamV5</p>";
    }

    //경로변수
    @GetMapping(value = "users/{user_id}") // {id}가 변수. 그 변수를 주소에 붙이겟다.
    public String userRequest(@PathVariable(name="user_id")String id){ // PathVariable로써 id 데이터를 받겟다.
        log.info("userid: {}", id); // 변수명은 되도록 통일하십셔
        return "<h1>ok</h1><br><p>this ok is come from userRequest</p>";
    }
    @GetMapping(value = "requestLogin")
    public String requestLogin(@RequestParam(name="id") String id,
         @RequestParam(name="password") String password){
        log.info("id: {}", id);
        log.info("password: {}", password);

        if(id.equals("hong") && password.equals("1234")){
            return "<h1>ok</h1><br><p>this ok is come from requestLogin</p>";
        }
        return "<script>alert('Id / Password is not commit')</script>" +
                "<h1>bad Login</h1>";
    }

    @GetMapping("setCookies")
    public String setCookies(HttpServletResponse response){ //응답 객체. ServletRequest랑 다름
        Cookie cookie = new Cookie("data", "안녕하세요");
        cookie.setPath("/"); // cookie를 생성해서, 해당 루트로 설정
        response.addCookie(cookie); // 쿠키를 설정된 루트에 저장
        return "ok";
    }

    @GetMapping("getCookies")
    public String getCookies(@CookieValue(name = "data")String data){
        log.info("cookie: {}", data);
        return "ok";
    }
    @GetMapping("removeCookies")
    public String removeCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("data", null); // 'data'란 이름의 쿠키를 null로 덮어쓰기
        cookie.setPath("/");
        cookie.setMaxAge(0); // cookie의 수명을 0(초)로 설정하기.
        response.addCookie(cookie);
        return "ok";
    }

}

