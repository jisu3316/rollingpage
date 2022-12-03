package com.jg.rollingpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RollingpageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RollingpageApplication.class, args);
    }

    @GetMapping
    public String home() {
        return "hello";
    }
}
