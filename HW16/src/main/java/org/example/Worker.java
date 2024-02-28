package org.example;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    @Cache(DBConnect.class)
    public List<Integer> fibonachi(int i) {
        // Проверить, есть ли уже кэшированные данные для данного аргумента i
        List<Integer> cachedData = getCachedData(i);
        if (cachedData != null) {
            return cachedData;
        }

        // Создать экземпляр класса H2DB
        Source source = createSource(DBConnect.class);

        // Получить данные из базы данных или вычислить их
        List<Integer> data = source.getData(i);
        if (data == null) {
            data = calculateFibonachi(i);
            source.saveData(i, data);
        }

        // Сохранить данные в кэше
        cacheData(i, data);

        return data;
    }

    private List<Integer> getCachedData(int i) {
        // Получить кэшированные данные для аргумента i
        return null;
    }

    private void cacheData(int i, List<Integer> data) {
        // Сохранить кэшированные данные для аргумента i
    }

    private Source createSource(Class<? extends Source> sourceClass) {
        // Создать экземпляр класса источника данных
        return null;
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
