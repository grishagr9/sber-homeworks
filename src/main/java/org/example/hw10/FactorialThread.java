package org.example.hw10;

import lombok.AllArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
public class FactorialThread implements Runnable{

    int number;

    @Override
    public void run() {
        BigInteger res = calculate();
        System.out.printf("%d! = %d\n", number, res);
    }

    public BigInteger calculate(){
        if(number < 0){
            throw new IllegalArgumentException("number can not be negative");
        }
        BigInteger res = new BigInteger("1");
        int i = number;
        while(i > 1){
            res = res.multiply(BigInteger.valueOf(i));
            i--;
        }
        return res;
    }
}
