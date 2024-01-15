package org.example.hw6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void questionsTask(){
        System.out.println("1. Что означает аннотация  Before?");
        System.out.println("2. Как в тесте проверить, что метод должен бросить исключение?");
        System.out.println("3. Что такое mock? Spy?");
        System.out.println("4. Для чего применяется статический метод  Mockito.verify?");


        System.err.println("1. Аннотация @Before в Java используется для отметки метода, который должен выполниться" +
                " перед каждым тестовым методом в классе, содержащем тесты. Это позволяет выполнять предварительную настройку, " +
                "инициализацию или другие операции перед каждым тестом, чтобы контекст был одинаковым для всех тестовых методов " +
                "и упростить написание тестов.");
        System.err.println("2. Assertions.assertThrows().");
        System.out.println("3. ");
        System.out.println("4. ");
    }

    static void task1(){
        Integer[] arr1 = new Integer[]{1,2,3};
        String[] arr2 = new String[]{"a","b","c"};
        MyArrayIterator<Integer> intIter = new MyArrayIterator<>(arr1);
        MyArrayIterator<String> stringIter = new MyArrayIterator<>(arr2);

        while (intIter.hasNext()){
            System.out.print(intIter.next());
        }
        while (stringIter.hasNext()){
            System.out.print(stringIter.next());
        }
    }
    public static void main(String[] args) {
        //questionsTask();
        task1();
    }
}
