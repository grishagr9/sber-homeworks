package org.example;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private static Source dbConnect;

    public Worker(){
       dbConnect = new DBConnect();
    }

    @Cache(DBConnect.class)
    public List<Integer> fibonachi(int i) {
        // Проверить, есть ли уже кэшированные данные для данного аргумента i
        List<Integer> cachedData = getCachedData(i);
        if (cachedData != null) {
            return cachedData;
        }

        // Получить данные из базы данных или вычислить их
        List<Integer> data = dbConnect.getData(i);
        if (data == null) {
            data = calculateFibonachi(i);
            dbConnect.saveData(i, data);
        }

        // Сохранить данные в кэше
        cacheData(i, data);

        return data;
    }

    private List<Integer> getCachedData(int i) {
        return dbConnect.getData(i);
    }

    private void cacheData(int i, List<Integer> data) {
        dbConnect.saveData(i, data);
    }

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
