package org.example.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static boolean readContent(String url) throws IOException, MalformedURLException {
        URL website = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(website.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        return true;
    }
    static void task1(){
        TerminalImpl terminal = new TerminalImpl();
        terminal.StartWork();
    }
    static void task2(){
        System.out.println("Введите url адрес страницы ");
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        while (!result){
            try {
                String url = scanner.nextLine();
                result = readContent(url);
            }catch (IOException ioException){
                System.err.println(ioException.getMessage());
                System.out.print("Введите url адрес страницы еще раз");
            }
        }
    }
    public static void main(String[] args)  {
        //task1();
        //task2();
    }
}
