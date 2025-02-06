package com.example.web.controller;

import com.example.web.exception.MemberNotFoundException;
import com.example.web.model.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionRestControllerAdvice {
    @ExceptionHandler // 이 컨트롤러에서 예외가 발생할 경우 처리할 메서드를 지정
    //메서드의 파라미터로 받는 예외가 발생하면 이 메서드에서 처리한다,
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult illegalExHandler(IllegalArgumentException e){
        log.info(e.getMessage());
        return new ErrorResult("Bad_Request", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> memberExHandler(MemberNotFoundException e){
        log.info("ex : {}", e.getMessage());
        ErrorResult result = new ErrorResult("MemberNotFound", e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> memberExHandler(Exception e){
        log.info("ex : {}", e.getMessage());
        ErrorResult result = new ErrorResult("Global-Ex", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResult("Global Exception", e.getMessage())
        );
    }
}
