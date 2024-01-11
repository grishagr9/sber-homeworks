package org.example.hw5;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class PerfomanceProxy implements Calculator{

    private static CalculatorImpl calculator;

    public PerfomanceProxy(CalculatorImpl calculator){
        PerfomanceProxy.calculator = calculator;
    }

    @Override
    public int calc(int arg) throws NoSuchMethodException {
        Method method = calculator.getClass().getMethod("calc", int.class);
        if(method.getAnnotation(Metric.class).value()){
            long startTime = System.nanoTime();
            int result = calculator.calc(arg);
            long endTime = System.nanoTime();
            System.out.printf("Время работы метода %d\n", endTime-startTime);
            return result;
        }
        return calculator.calc(arg);
    }
}
