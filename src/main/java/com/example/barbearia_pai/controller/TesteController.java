package com.example.barbearia_pai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public String testandoController(){
        return "Heyy API is working now";
    }

}
