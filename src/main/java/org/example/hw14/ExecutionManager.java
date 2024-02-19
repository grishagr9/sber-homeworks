package org.example.hw14;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
