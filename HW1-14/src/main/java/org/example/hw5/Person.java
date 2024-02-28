package org.example.hw5;

import lombok.*;



import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private String name;
    private int age;
    private boolean man;
    public Person() {
    }

    public void print(){
        System.out.printf("hello, %s %d years old%n",name, age);
    }

    private void incAge(){
        age+=1;
    }

}
