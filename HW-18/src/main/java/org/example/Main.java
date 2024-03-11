package org.example;

import org.example.jdbc.JDBCTemplateDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var factory =  SpringApplication.run(Main.class);
        var service = factory.getBean(RecipeService.class);
        service.start();
    }
}