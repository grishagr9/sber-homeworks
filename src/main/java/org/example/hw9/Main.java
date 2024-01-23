package org.example.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person("a",30));
        someCollection.add(new Person("b",18));
        someCollection.add(new Person("c",40));

        var m = Streams.of(someCollection).
                filter(p->p.getAge()>20).
                transform( p -> new Person(p.getAge() + 30))
                .toList();
        System.out.println(m.toString());

        Stream.of(new Person("a",30),new Person("b",18))
                .filter(p->p.getAge()>20)
                .toArray();
//        Map m = Streams.of(someCollection)
//                .filter(p -> p.getAge() > 20)
//                .transform( p -> new Person(p.getAge() + 30)))
//                                      .toMap(p -> p.getName(), p -> p);


    }
}
