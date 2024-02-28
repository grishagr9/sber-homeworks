package org.example.hw11;

import javax.swing.text.html.Option;

import java.util.ArrayList;
import java.util.Optional;

import static java.lang.Thread.sleep;

public class Main {

    static void task1(){
        ThreadPool threadPool = new FixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(() -> {
                System.out.println("doWork" + Thread.currentThread().getName());
            });
        }
        threadPool.start();

    }

    static void task2(){
        ThreadPool threadPool = new ScalableThreadPool(2, 5);

        threadPool.start();

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName());
                try {
                    sleep(1000); // Имитация выполнения задачи
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((ScalableThreadPool) threadPool).stop();
    }

    public static void main(String[] args) {
        //task1();
        //task2();
    }
}
