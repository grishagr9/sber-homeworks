package org.example.hw9;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
    void givenPersonCollection_whenAllConditional_thenReturnMap() {
        Map<?, Person> m = Streams.of(someCollection).
                filter(p->p.getAge()>20).
                transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(Person::getName, p->p);

        Assertions.assertEquals(m.keySet().toArray()[0],"Bob");
    }

    @Test
    void givenPersonCollection_whenAllConditional_thenReturnTwoMapElement() {
        Map<?, Person> m = Streams.of(someCollection).
                filter(p->p.getAge()>20).
                transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(Person::getName, p->p);

        Assertions.assertEquals(2, m.size());
    }

    @Test
    void givenEmptyPersonCollection_whenAllCondition_thenReturnEmptyMap() {
        Map<?, Person> m = Streams.of(new ArrayList<Person>()).
                filter(p->p.getAge()>20).
                transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(Person::getName, p->p);

        Assertions.assertEquals(0, m.size());
    }

    @Test
    void givenCollection_whenCallOf_thenReturnStreamsClass() {
        Streams<Person> m = Streams.of(someCollection);

        Assertions.assertEquals("Streams",m.getClass().getSimpleName());
    }

    @Test
    void givenIntegerCondition_whenFiltering_thenReturnNewCollection() {
        //given
        Predicate<Integer> condition = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        List<Integer> collection = List.of(1, -2, -3, -4, -5, 6);

        //when
        var m = Streams.of(collection).
                filter(condition).toList().toArray(new Integer[0]);

        //then
        Assertions.assertArrayEquals(new Integer[]{1,6}, m);
    }

    @Test
    void givenStringCondition_whenFiltering_thenReturnNewCollection() {
        //given
        Predicate<String> condition = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.startsWith("ka");
            }
        };
        List<String> collection = List.of("emma", "kate", "karine", "bob", "kostya", "kamen");

        //when
        var m = Streams.of(collection).
                filter(condition).toList().toArray(new String[0]);

        //then
        Assertions.assertArrayEquals(new String[]{"kate", "karine", "kamen"}, m);
    }
}