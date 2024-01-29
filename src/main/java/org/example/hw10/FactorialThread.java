package org.example.hw10;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FactorialThread implements Runnable{

    int number;

    @Override
    public void run() {
        long res = 1;
        while(number > 1){
            res *= number;
            number--;
        }
        System.out.println(res);
    }
}
