package org.example.hw14;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Task<T> {

    private final Callable<? extends T> callable;
    private volatile FutureTask<T> futureTask;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (futureTask == null) {
            FutureTask<T> newTask = new FutureTask<>(() -> {
                try {
                    return callable.call();
                } catch (Exception e) {
                    throw new TaskExecutionException("Error executing task", e);
                }
            });

            synchronized (this) {
                if (futureTask == null) {
                    futureTask = newTask;
                    newTask.run();
                }
            }
        }
        try {
            return futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new TaskExecutionException("Error getting task result", e);
        }
    }
}
