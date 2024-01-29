package org.example.hw10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final String PATH_NUMBERS = "numbers.txt";

    /**
     * генерация файла со случайными числами
     * @param n количество случайных чисел в файле
     */
    private static void generateFile(int n){
        Random randomNumber = new Random();
        try(FileWriter fileWriter = new FileWriter(PATH_NUMBERS)){
            for (int i = 0; i < n; i++) {
                int number = randomNumber.nextInt(20);
                fileWriter.write(Integer.toString(number));
                fileWriter.write("\n");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private static List<Integer> readNumbersFromFile(String path){
        List<Integer> result = new ArrayList<>();
        try(FileReader fileReader = new FileReader(path)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line != null){
                result.add(Integer.parseInt(line));
                line = bufferedReader.readLine();
            }
        }catch (IOException | NumberFormatException e){
            System.err.println(e.getMessage());
        }

        return result;
    }

    public static void main(String[] args) {
        final int countNum = 10;
        generateFile(countNum);
        List<Integer> list = readNumbersFromFile(PATH_NUMBERS);
        System.out.println(list);
        for (int i = 0; i < countNum; i++) {
            Thread thread = new Thread(new FactorialThread(list.get(i)));
            thread.start();
        }
    }
}
