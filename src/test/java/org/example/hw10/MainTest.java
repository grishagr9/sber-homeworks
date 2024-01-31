package org.example.hw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void givenNum_whenCreateNumOfThreads_thenPrintFactorial(){
        Main.calculateFact(10);
    }
}