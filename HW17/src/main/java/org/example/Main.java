package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {

    private final static String INPUT_PATH = "HW17\\src\\main\\resources\\links.txt";
    private final static String OUTPUT_PATH = "HW17\\src\\main\\resources\\downloads";
    public static void main(String[] args) throws IOException, InterruptedException {
        var factory = SpringApplication.run(Main.class, args);
        var worker = factory.getBean(Worker.class);
        worker.run(INPUT_PATH, OUTPUT_PATH);
    }

}