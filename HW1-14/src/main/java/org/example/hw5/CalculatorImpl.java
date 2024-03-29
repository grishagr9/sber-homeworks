package org.example.hw5;

public class CalculatorImpl implements Calculator{

    @Override
    @Metric(value = true)
    public int calc(int arg) {
        if(arg<0){
            throw new IllegalArgumentException();
        }
        return helperCalc(arg);
    }

    private int helperCalc(int n){
        if(n == 0){
            return 1;
        }
        return helperCalc(n-1) * n;
    }
}
