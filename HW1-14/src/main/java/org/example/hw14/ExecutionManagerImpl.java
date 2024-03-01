package org.example.hw14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionManagerImpl implements ExecutionManager{

    private final ExecutorService executorService;

    public ExecutionManagerImpl(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
       ContextImpl context = new ContextImpl(tasks.length, callback);
        for (Runnable task : tasks) {
            Future<?> future = executorService.submit(() -> {
                try {
                    task.run();
                    context.taskCompleted();
                } catch (Exception e) {
                    context.taskFailed();
                }
            });
            context.addFuture(future);
        }
        return context;
    }
}
