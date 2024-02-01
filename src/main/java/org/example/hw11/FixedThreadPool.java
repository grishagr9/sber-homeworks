package org.example.hw11;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class FixedThreadPool implements ThreadPool{

    private final int countThreads;
    private final Queue<Runnable> taskQueue;

    private final MyThread[] threads;

    public FixedThreadPool(int countThreads){
        this.countThreads = countThreads;
        this.taskQueue = new LinkedList<>();
        threads = new MyThread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
    }

    @Override
    public void start() {
        synchronized (taskQueue){
            taskQueue.notifyAll();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (taskQueue){
            taskQueue.add(runnable);
            taskQueue.notify();
        }
    }

}
