package org.example.hw2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> book;

    public PhoneBook(){
        book = new HashMap<>();
    }

    public void add(String surname, String phone){
        if(!book.containsKey(surname)){
            book.put(surname, new HashSet<>());
        }
        book.get(surname).add(phone);
    }

    public String get(String surname){
        return book.get(surname).toString();
    }

    public void print(){
        for(Map.Entry<String,Set<String>> m: book.entrySet()){
            System.out.println(m.getKey() + "  "+m.getValue());
        }
    }
}
