package org.example.hw10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    private static File generateFile(int n){
        Random randomNumber = new Random();
        File file = new File("numbers.txt");
        try(FileWriter fileWriter = new FileWriter(file)){
            for (int i = 0; i < n; i++) {
                int number = randomNumber.nextInt(50);
                fileWriter.write(Integer.toString(number));
                fileWriter.write("\n");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return file;
    }
    public static void main(String[] args) {
        generateFile(10);
    }
}
