package com.example.myproject2022;

import com.example.myproject2022.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyProject2022Application {

    public static void main(String[] args) {
        SpringApplication.run(MyProject2022Application.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
        };
    }
}
