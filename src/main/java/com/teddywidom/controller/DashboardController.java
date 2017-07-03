package com.teddywidom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @RequestMapping("/")
    public String dashboard() {
        return "Hello, Blargh World!";
    }
}
