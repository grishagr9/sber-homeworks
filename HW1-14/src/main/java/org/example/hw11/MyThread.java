package org.example.hw11;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("doWork " +Thread.currentThread().getName());
    }
}
