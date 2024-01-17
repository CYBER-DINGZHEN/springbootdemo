package com.itheima.springwebdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController
//请求处理类
public class Hellocontroller {
@RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "hello world";
    }
}
