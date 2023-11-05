package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin-page";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user-page";
    }
}
