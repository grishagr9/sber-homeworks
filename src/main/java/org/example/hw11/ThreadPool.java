package org.example.hw11;

public interface ThreadPool{

    void start();
    void execute(Runnable runnable);
}
