package com.example.web.model;

import lombok.Data;

@Data
public class Member {
    private String id;
    private String password;
    private String name;
    private String gender;
    private String email;
    private String domain;
}
