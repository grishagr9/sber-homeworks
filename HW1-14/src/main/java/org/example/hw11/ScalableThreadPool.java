package org.example.hw11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableThreadPool implements ThreadPool{

    private final int minThreads;
    private final int maxThreads;

    private final BlockingQueue<Runnable> taskQueue;

    private int numThreads;

    private final Thread[] threads;

    public ScalableThreadPool(int minThreads, int maxThreads) {
        this.minThreads = minThreads;
        this.maxThreads = maxThreads;
        this.taskQueue =  new LinkedBlockingQueue<>();
        this.numThreads = minThreads;
        this.threads = new Thread[maxThreads];

        for (int i = 0; i < minThreads; i++) {
            new MyThread().start();
        }
    }

    /**
     * позволяет начать выполнение задач в очереди, уведомляя все потоки, ожидающие выполнения задач.
     */
    @Override
    public void start() {
        synchronized (taskQueue){
            taskQueue.notifyAll();
        }
    }

    /**
     * добавляет новую задачу в очередь. Если количество задач превышает число потоков и не достигло максимального значения, создается новый поток.
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {
        taskQueue.offer(runnable);
        if (taskQueue.size() > numThreads && numThreads < maxThreads) {
            threads[numThreads] = new MyThread();
            threads[numThreads].start();
            numThreads++;
        }
        if (taskQueue.isEmpty() && numThreads> minThreads) {
            taskQueue.offer(() -> {}); // Пустая задача для принудительного выхода из блокировки потока
            numThreads++;
        }
    }

    /**
     * останавливает все потоки, вызывая метод interrupt().
     */
    public void stop() {
        for (int i = 0; i < maxThreads; i++) {
            threads[i].interrupt();
        }
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    if (task == null) {
                        break;
                    }
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
