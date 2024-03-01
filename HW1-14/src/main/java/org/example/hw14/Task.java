package org.example.hw14;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task<T> {
    private final Callable<? extends T> callable;
    private T result;
    private boolean isResultReady = false;
    private RuntimeException exception;
    private final Lock lock = new ReentrantLock();

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (!isResultReady) {
            try {
                lock.lock();
                if (!isResultReady) {
                    try {
                        result = callable.call();
                        isResultReady = true;
                    } catch (Exception e) {
                        exception = new TaskExecutionException("Error executing task", e);
                        throw exception;
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        if (exception != null) {
            throw exception;
        }

        return result;
    }
}
