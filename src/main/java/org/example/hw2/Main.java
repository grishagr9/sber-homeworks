package org.example.hw2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("task1");
        String[] strings ={
                "dog", "cat", "dog", "cow", "pig",
                "rabbit", "horse", "goat", "dog", "pig",
                "cat",  "dog", "cow", "goat","rabbit"
        };

        Map<String, Integer> farm = new HashMap<>();
        for (String item: strings) {
            if(farm.containsKey(item)){
                farm.put(item, farm.get(item)+1);
            }else {
                farm.put(item, 1);
            }
        }

        System.out.println("количество уникальных слов = " + farm.size());
        System.out.println("уникальные слова " + farm.keySet());
        System.out.println("сколько раз встречается каждое слово " + farm);

        System.out.println("task2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "89281412424");
        phoneBook.add("Ivanov", "89999999999");
        phoneBook.add("Sidorov", "89891424242");
        phoneBook.add("Ivanov", "89898984887");
        phoneBook.add("Messi", "89341283333");
        phoneBook.add("Messi", "89341283333");

        phoneBook.print();
    }
}
