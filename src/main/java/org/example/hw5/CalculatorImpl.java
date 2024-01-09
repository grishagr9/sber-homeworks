package org.example.hw5;

public class CalculatorImpl implements Calculator{

    @Override
    public int calc(int arg) {
        return helperCalc(arg);
    }

    private int helperCalc(int n){
        if(n == 0){
            return 1;
        }
        return helperCalc(n-1) * n;
    }
}
