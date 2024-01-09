package org.example.hw5;

public class Person {

    public String name;
    public int age;
    private long id;

    public void print(){
        System.out.printf("hello, %s %d years old%n",name, age);
    }

    private void incAge(){
        age+=1;
    }
}
