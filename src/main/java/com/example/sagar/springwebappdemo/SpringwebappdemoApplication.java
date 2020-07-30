package com.example.sagar.springwebappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringwebappdemoApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context= SpringApplication.run(SpringwebappdemoApplication.class, args);
    }

    @GetMapping(value = "/")
    public String showMessage()
    {
        return "Hello world";
    }


}
