package org.example.hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void givenNum_whenCreateNumOfThreads_thenPrintFactorial(){
        Main.calculateFact(10);
    }

    @Test
    void givenZero_whenCalculate_thenReturnOne(){
        //given
        FactorialThread factorialThread = new FactorialThread(0);

        //when
        BigInteger result = factorialThread.calculate();

        //then
        BigInteger expected = BigInteger.ONE;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void givenNum_whenCalculate_thenReturnRight(){
        //given
        FactorialThread factorialThread = new FactorialThread(4);

        //when
        BigInteger result = factorialThread.calculate();

        //then
        BigInteger expected = BigInteger.valueOf(24);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void givenNegative_whenCalculate_thenException(){
        //given
        FactorialThread factorialThread = new FactorialThread(-4);

        //then
        assertThrows(IllegalArgumentException.class, factorialThread::calculate);
    }
}