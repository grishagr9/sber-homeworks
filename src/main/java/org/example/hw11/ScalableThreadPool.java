package org.example.hw11;

import java.util.LinkedList;
import java.util.Queue;

public class ScalableThreadPool implements ThreadPool{

    private final int minThreads;
    private final int maxThreads;

    private final Queue<Runnable> taskQueue;

    private int numThreads;

    public ScalableThreadPool(int minThreads, int maxThreads) {
        this.minThreads = minThreads;
        this.maxThreads = maxThreads;
        this.taskQueue = new LinkedList<>();
        this.numThreads = minThreads;

        for (int i = 0; i < minThreads; i++) {
            new MyThread().start();
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

            if(numThreads == minThreads){
                numThreads++;
                new MyThread().start();
            }

            taskQueue.notify();
        }
    }
}
