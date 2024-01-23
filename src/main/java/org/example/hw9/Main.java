package org.example.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person("Bob",30));
        someCollection.add(new Person("Steve",18));
        someCollection.add(new Person("Mikel",40));

        Map<?, Person> m = Streams.of(someCollection).
                filter(p->p.getAge()>20).
                transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(Person::getName, p->p);

        System.out.println(m.toString());
    }
}
