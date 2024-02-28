package org.example.hw5;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param param
     */
    @Metric
    int calc(int arg) throws NoSuchMethodException;
}
