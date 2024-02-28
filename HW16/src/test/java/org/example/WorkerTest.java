package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void givenNum_whenCalculate_returnResult() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //given
        int i = 3;
        List<Integer> excepted = Arrays.asList(1, 1, 2);
        Class<?> clazz = Class.forName("org.example.Worker");
        Method method = clazz.getDeclaredMethod("calculateFibonachi", int.class);
        method.setAccessible(true);

        //when
        List<Integer> actual = (List<Integer>) method.invoke(clazz.newInstance(), i);
        method.setAccessible(false);

        //then
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void givenBigNum_whenCalculate_thenReturn() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //given
        int i = 10;
        List<Integer> excepted = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Class<?> clazz = Class.forName("org.example.Worker");
        Method method = clazz.getDeclaredMethod("calculateFibonachi", int.class);
        method.setAccessible(true);

        //when
        List<Integer> actual = (List<Integer>) method.invoke(clazz.newInstance(), i);
        method.setAccessible(false);

        //then
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void givenNum_whenStartWork_thenResult(){
        //given
        Worker worker = new Worker();
        int i = 9;
        List<Integer> excepted = List.of(1, 1, 2, 3, 5, 8, 13, 21, 34);

        //when
        List<Integer> actual = worker.fibonachi(9);

        //then
        Assertions.assertEquals(excepted, actual);
    }

}