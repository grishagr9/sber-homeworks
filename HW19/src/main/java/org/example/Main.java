package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var factory = SpringApplication.run(Main.class);
        var worker = factory.getBean(Worker.class);

        worker.start();
    }
}