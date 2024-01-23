package org.example.hw9;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private String name;

    private int age;

    public Person(int age){
        this.age = age;
    }
}
