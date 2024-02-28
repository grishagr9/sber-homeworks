package org.example.hw11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void givenCountThread_whenStart_thenDoWork(){
        final int given = 3;
        ThreadPool threadPool = new FixedThreadPool(given);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(() -> {
                System.out.println("doWork" + Thread.currentThread().getName());
            });
        }
        threadPool.start();

        Assertions.assertEquals(((FixedThreadPool) threadPool).getCountThreads(), given);
    }



}