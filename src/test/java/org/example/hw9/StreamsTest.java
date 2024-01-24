package org.example.hw9;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {

    List<Person> someCollection = new ArrayList<>();

    @BeforeEach
    public void init(){
        someCollection.add(new Person("Bob",30));
        someCollection.add(new Person("Steve",18));
        someCollection.add(new Person("Mikel",40));
    }

    @Test
    void of() {
        Map<?, Person> m = Streams.of(someCollection).
                filter(p->p.getAge()>20).
                transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(Person::getName, p->p);

        Assertions.assertEquals(m.keySet().toArray()[0],"Bob");
    }

    @Test
    void filter() {
    }

    @Test
    void transform() {
    }

    @Test
    void toMap() {
    }

    @Test
    void toList() {
    }
}