package org.example;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private static Source dbConnect;

    public Worker(){
       dbConnect = new DBConnect();
    }

    /**
     * Получение списка чисел фибоначи до i-го элемента
     * @param i элемент, до которого рассчитывать числа фибоначи
     * @return
     */
    @Cache(DBConnect.class)
    public List<Integer> fibonachi(int i) {
        List<Integer> data = getCachedData(i);
        if (data == null) {
            data = calculateFibonachi(i);
            cacheData(i, data);
        }
        return data;
    }

    /**
     * Инкапсуляция метода getData(int i) интерфейса Source
     * @param i
     * @return
     */
    private List<Integer> getCachedData(int i) {
        return dbConnect.getData(i);
    }

    /**
     * Инкапсуляция метода saveData(int i, List<Integer> data) интерфейса Source
     * @param i
     * @param data
     */
    private void cacheData(int i, List<Integer> data) {
        dbConnect.saveData(i, data);
    }

    /**
     * Расчет чисел фибоначи до i-го элемента
     * @param i
     * @return
     */
    private List<Integer> calculateFibonachi(int i) {
        if(i <= 0){
            throw new IllegalArgumentException("number can not be negative");
        }

        List<Integer> result = new ArrayList<>();
        result.add(1);
        if(i == 1){
            return result;
        }
        result.add(1);
        if(i == 2){
            return result;
        }

        for (int j = 2; j < i; j++) {
            result.add(result.get(j-1) + result.get(j-2));
        }

        return result;
    }
}
