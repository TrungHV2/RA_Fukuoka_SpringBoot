package com.example.session7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class Session7Application {

    @GetMapping
    public String get() {
        return "Welcome to OAuth2!";
    }

    @GetMapping("/user")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(Session7Application.class, args);
    }

}
