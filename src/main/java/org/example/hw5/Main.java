package org.example.hw5;

import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static final String MONDAY = "MONDAY";
    public static final String VTORNIK = "MONDAY";
    static void task1(){
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.calc(4));
    }
    static void task2(){
        Student s = new Student();
        Person p = new Person();

        Class<?> clazz = s.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Методы класса:");
        for (Method method: methods) {
            System.out.println(method.getName());
        }
        System.out.println("Методы родительских классов");
        while (true) {
            clazz = clazz.getSuperclass();
            if(clazz == null){
                break;
            }
            System.out.printf("Class %s%n", clazz.getSimpleName());
            Method[] methodsParent = clazz.getDeclaredMethods();
            for (Method method : methodsParent) {
                System.out.println(method.getName());
            }
        }
    }
    static void task3(){
        Person person = new Person();
        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method: methods) {
            if(method.getName().startsWith("get") || method.getName().startsWith("is")){
                System.out.println(method.getName());
            }
        }
    }
    static void task4(){
        System.out.println(MONDAY);
        System.out.println(VTORNIK);
    }
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        task4();
    }
}
