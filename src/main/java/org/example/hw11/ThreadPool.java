package org.example.hw11;

public interface ThreadPool extends Runnable{
    void execute(Runnable runnable);
}
