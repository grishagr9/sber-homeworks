package org.example.hw11;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class FixedThreadPool implements ThreadPool{

    private final int countThreads; // Количество потоков
    private final Queue<Runnable> taskQueue;// Очередь задач

    private final MyThread[] threads;// Массив потоков

    public FixedThreadPool(int countThreads){
        this.countThreads = countThreads;
        this.taskQueue = new LinkedList<>();
        threads = new MyThread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
    }

    /**
     * Запуск потоков
     */
    @Override
    public void start() {
        synchronized (taskQueue){
            taskQueue.notifyAll(); // Уведомление всех потоков
        }
    }

    /**
     * Метод для выполнения задачи, Добавляет задачу в очередь, уведомляет потоки
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {
        synchronized (taskQueue){
            taskQueue.add(runnable);
            taskQueue.notify();
        }
    }

}
