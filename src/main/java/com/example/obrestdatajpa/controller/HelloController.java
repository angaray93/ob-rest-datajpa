package com.example.obrestdatajpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Value("${app.varexample}")
    String message;

    public String holaMundo() {
        System.out.println(message);
        return "Hola mundo";
    }
}
