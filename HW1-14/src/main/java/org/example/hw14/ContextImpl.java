package org.example.hw14;

import java.util.concurrent.Future;

public class ContextImpl implements Context{
    private final int taskCount;
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;

    private final Runnable callback;
    private final Future<?>[] futures;

    public ContextImpl(int taskCount, Runnable callback) {
        this.taskCount = taskCount;
        this.callback = callback;
        this.futures = new Future<?>[taskCount];
    }

    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    @Override
    public void interrupt() {
        for (Future<?> future : futures) {
            future.cancel(true);
            interruptedTaskCount++;
        }
    }

    @Override
    public boolean isFinished() {
        return completedTaskCount + failedTaskCount + interruptedTaskCount == taskCount;
    }

    public synchronized void taskCompleted() {
        completedTaskCount++;
        if (isFinished()) {
            callback.run();
        }
    }

    public synchronized void taskFailed() {
        failedTaskCount++;
        if (isFinished()) {
            callback.run();
        }
    }

    public synchronized void addFuture(Future<?> future) {
        for (int i = 0; i < futures.length; i++) {
            if (futures[i] == null) {
                futures[i] = future;
                break;
            }
        }
    }
}
