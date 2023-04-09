package com.example.testbot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestBot2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestBot2Application.class, args);
    }

}

